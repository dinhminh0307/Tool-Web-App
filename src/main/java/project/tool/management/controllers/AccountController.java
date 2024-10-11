package project.tool.management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.tool.management.dto.AccountResponse;
import project.tool.management.models.Accounts;
import project.tool.management.services.AccountService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from this origin
public class AccountController {
    @Autowired
    private AccountService _accountService;

    @PostMapping("register")
    public ResponseEntity<AccountResponse> register(@RequestBody Accounts accounts) {
        return ResponseEntity.ok(_accountService.register(accounts));
    }
}
