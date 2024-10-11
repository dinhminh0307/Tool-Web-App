package project.tool.management.utils;

import org.springframework.stereotype.Service;
import project.tool.management.dto.AccountResponse;
import project.tool.management.models.Accounts;

@Service
public class DTOConvert {
    public AccountResponse toAccountResponse(Accounts accounts) {
        if(accounts != null) {
            return new AccountResponse(accounts.getId(), accounts.getFullName(), accounts.getLastName(), accounts.getFirstName(),
                    accounts.getDob(), accounts.getPhoneNumber(), accounts.getCompanies(), accounts.getProjects());
        }
        return  null;
    }
}
