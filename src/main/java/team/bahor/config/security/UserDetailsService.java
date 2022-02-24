package team.bahor.config.security;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import team.bahor.entity.user.User;
import team.bahor.repository.user.UserRepository;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository repository;

    public UserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findUserByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("USERNAME NOT FOUND"));
        return new UserDetails(user);
    }
}
