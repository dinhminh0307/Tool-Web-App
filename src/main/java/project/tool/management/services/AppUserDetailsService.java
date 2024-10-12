package project.tool.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import project.tool.management.models.Accounts;
import project.tool.management.repo.DBAccountRepo;

import java.util.Optional;

@Component
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private DBAccountRepo _accountRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Find the user by email
        Optional<Accounts> accounts = _accountRepo.findBy_email(email);

        // If account is present, map it to UserDetails
        if (accounts.isPresent()) {
            return mapToUserDetails(accounts.get());  // Pass the actual Accounts object
        }

        // If not found, throw an exception
        throw new UsernameNotFoundException("User not found with email: " + email);
    }

    // Helper method to convert Accounts to UserDetails
    private UserDetails mapToUserDetails(Accounts account) {
        return org.springframework.security.core.userdetails.User.withUsername(account.getEmail())
                .password(account.getPassword())  // Assuming the password is already encrypted
//                .authorities(account.getRole().name())  // Assuming role is a simple enum like USER or ADMIN
                .build();
    }
}
