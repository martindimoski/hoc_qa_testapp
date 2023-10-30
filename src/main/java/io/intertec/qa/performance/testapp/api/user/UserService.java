package io.intertec.qa.performance.testapp.api.user;

import io.intertec.qa.performance.testapp.db.entity.User;
import io.intertec.qa.performance.testapp.db.repository.UserRepository;
import io.intertec.qa.performance.testapp.exceptions.DuplicateUserException;
import io.intertec.qa.performance.testapp.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = getUser(username);
        return org.springframework.security.core.userdetails.User.builder().username(user.getUsername())
                .password(user.getPassword()).roles("USER").build();
    }

    public User createUser(final User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new DuplicateUserException();
        } else {
            return userRepository.save(user);
        }
    }

    public User getUser(final String username) {
        return userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }

    public User getAuthenticatedUser() {
        return getUser(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
