package project.tool.management.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.tool.management.dto.AccountResponse;
import project.tool.management.models.Accounts;
import project.tool.management.services.AccountService;

@RestController
@RequestMapping("/")
public class AccountController {

    @Autowired
    private AccountService _accountService;

    @MutationMapping
    public AccountResponse createAccount(
            @Argument("email") String _email,
            @Argument("fullName") String _fullName,
            @Argument("lastName") String _lastName,
            @Argument("firstName") String _firstName,
            @Argument("dob") String _dob,
            @Argument("phoneNumber") String _phoneNumber,
            @Argument("companies") String _companies,
            @Argument("password") String _password) {

        // Create an account object without manually setting the ID
        Accounts account = new Accounts(null, _email, _fullName, _lastName, _firstName, _dob, _phoneNumber, _companies, null, _password, null);
        return _accountService.register(account);
    }

    @PostMapping("login")
    public ResponseEntity<?> loginAccount(@RequestBody Accounts accounts, HttpServletResponse response) {
        return ResponseEntity.ok(_accountService.login(accounts, response));
    }

    @GetMapping("")
    public String returnTest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
            return "No authenticated user";
        }

        return authentication.getName();
    }

}
