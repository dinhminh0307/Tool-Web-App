package project.tool.management.services;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.tool.management.exceptions.InvalidCredentialsException;
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
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication != null && authentication.isAuthenticated()) {
                String email = authentication.getName(); // The email was set as the principal during authentication
                System.out.println("email: " + email);

                // Find account by email or throw a custom exception if not found
                return _accountRepo.findBy_email(email)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
            }

            // If the authentication is null or not authenticated, throw an exception
            return null;
        }

}
