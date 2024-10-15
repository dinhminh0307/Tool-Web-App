package project.tool.management.services;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.tool.management.config.JwtAuthenticationFilter;
import project.tool.management.exceptions.InvalidCredentialsException;
import project.tool.management.exceptions.ResourceNotFoundException;
import project.tool.management.models.Accounts;
import project.tool.management.repo.DBAccountRepo;
import project.tool.management.utils.JwtUtil;

@Service
public class AuthenticateService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    DBAccountRepo _accountRepo;

    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    public boolean authenticateAccount(Accounts user, HttpServletResponse response) {
        try {
            // Perform authentication using the provided email and password
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );

            // If authentication is successful, generate JWT token and set it in a cookie
            if (authentication.isAuthenticated()) {
                String token = jwtUtil.generateToken(user.getEmail());
                System.out.println("Token: " + token);

                //update the token in the database
//                user.setToken(token);
//                _accountRepo.save(user);

                // Set JWT token in a secure HTTP-only cookie
                ResponseCookie jwtCookie = ResponseCookie.from("jwt", token)
                        .httpOnly(true)
                        .secure(false) // Set to true in production (HTTPS)
                        .path("/")
                        .maxAge(7 * 24 * 60 * 60)  // Token valid for 7 days
                        .sameSite("Lax")  // Prevent CSRF
                        .build();

                response.addHeader("Set-Cookie", jwtCookie.toString());

                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            // Catch authentication failures and throw InvalidCredentialsException
            throw new InvalidCredentialsException("Invalid email or password");
        }
    }


    public Accounts getAccountByToken() {
        String email = "";
        String token = jwtAuthenticationFilter.getBrowserToken();
        email = jwtUtil.extractEmail(token);
        System.out.println("Email is: " + email);
        Accounts foundAccount = _accountRepo.findBy_email(email)
                .orElseThrow(() ->  new ResourceNotFoundException("Can not find email: "));
        return foundAccount;

        // If not authenticated or authentication object is null, throw an exception or handle it
    }


}
