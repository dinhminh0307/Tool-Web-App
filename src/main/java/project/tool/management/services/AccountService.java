package project.tool.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import project.tool.management.dto.AccountResponse;
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

    public AccountResponse register(Accounts accounts) {
        String id = _idGenerator.generateAccountID(_accountRepo.findAll());
        System.out.println("Companay: " + accounts.getCompanies());
        accounts.setId(id);

        if(accounts.getPassword() != null) accounts.setPassword(_passwordEncoder.encode(accounts.getPassword()));

        Accounts savedAccount = _accountRepo.save(accounts);

        return dtoConvert.toAccountResponse(savedAccount);
    }
}
