package academy.everyonecodes.users.runner;

import academy.everyonecodes.users.persistence.domain.User;
import academy.everyonecodes.users.persistence.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ConfigurationProperties("users")
public class EnsureUserRunner {

    private User user;

    @Bean
    ApplicationRunner ensureAdminUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.existsByUsername(user.getUsername())) {
                return;
            }
            String password = user.getPassword();
            String encoded = passwordEncoder.encode(password);
            user.setPassword(encoded);
            userRepository.save(user);
        };
    }

    void setUser(User user) {
        this.user = user;
    }
}

