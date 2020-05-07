package academy.everyonecodes.users.logic;

import academy.everyonecodes.users.persistence.domain.User;
import academy.everyonecodes.users.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final String role;
    private final String login;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       @Value("${users.regular-user.authorities}") String role,
                       @Value("${users.message.login}")String login) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.role = role;
        this.login = login;
    }

    public User save(User user) {
        Optional<User> oUser = userRepository.findOneByUsername(user.getUsername());
        if (oUser.isEmpty()) {
            user.setAuthorities(Set.of(role));
            String password = passwordEncoder.encode(user.getPassword());
            user.setPassword(password);
            userRepository.save(user);
            return user;
        }
        return oUser.get();
    }

    public String login() {
        return login;
    }
}
