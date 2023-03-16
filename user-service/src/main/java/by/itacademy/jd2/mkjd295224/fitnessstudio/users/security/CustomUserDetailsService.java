package by.itacademy.jd2.mkjd295224.fitnessstudio.users.security;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.account.UserAccountService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserAccountService userAccountService;

    public CustomUserDetailsService(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.User user = userAccountService.getUserByUsername();
        return new User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }
}
