package project.tool.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails leader = User
                .withUsername("leader")
                .password("123") // raw
                .roles("leader", "user")
                .build();

        UserDetails user = User
                .withUsername("user")
                .password("{noop}222")
                .roles("user")
                .build();
        return  new InMemoryUserDetailsManager(leader, user);
    }
}
