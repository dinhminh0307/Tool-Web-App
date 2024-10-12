package project.tool.management.services;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import project.tool.management.dto.AccountResponse;
import project.tool.management.exceptions.DuplicateEmailHandler;
import project.tool.management.exceptions.InvalidCredentialsException;
import project.tool.management.exceptions.ResourceNotFoundException;
import project.tool.management.models.Accounts;
import project.tool.management.repo.DBAccountRepo;
import project.tool.management.utils.DTOConvert;
import project.tool.management.utils.GenerateID;

@Service
public class AccountService {
    @Autowired
    DBAccountRepo _accountRepo;

    @Autowired
    GenerateID _idGenerator;

    @Autowired
    private BCryptPasswordEncoder _passwordEncoder;

    @Autowired
    private DTOConvert dtoConvert;

    @Autowired
    AuthenticateService authenticateService;

    public AccountResponse login(Accounts user, HttpServletResponse response) {
        boolean isAuth = authenticateService.authenticateAccount(user, response);

        Accounts accounts = _accountRepo.findBy_email(user.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + user.getEmail()));
        ;

        return dtoConvert.toAccountResponse(accounts);
    }

    public AccountResponse register(Accounts accounts) {
        boolean existEmail = _accountRepo.findBy_email(accounts.getEmail()).isPresent();
        if(existEmail) {
            throw new DuplicateEmailHandler("Email is already registered: " + accounts.getEmail());
        }

        String id = _idGenerator.generateAccountID(_accountRepo.findAll());
        System.out.println("Companay: " + accounts.getCompanies());
        accounts.setId(id);

        if(accounts.getPassword() != null) accounts.setPassword(_passwordEncoder.encode(accounts.getPassword()));

        Accounts savedAccount = _accountRepo.save(accounts);

        return dtoConvert.toAccountResponse(savedAccount);
    }
}
