package academy.everyonecodes.users.logic;

import academy.everyonecodes.users.persistence.domain.User;
import academy.everyonecodes.users.persistence.repository.UserRepository;
import academy.everyonecodes.users.runner.EnsureUserRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @MockBean
    EnsureUserRunner ensureUserRunner;

    @MockBean
    PasswordEncoder passwordEncoder;

    @Value("${users.regular-user.authorities}")
    String role;

    @Value("${users.message.login}")
    String login;

    String password = "password";
    String username = "username";
    String encoded = "encoded";

    User user = new User(username, password);

    @Test
    void findsNonExistingUser() {
        when(userRepository.findOneByUsername(username))
                .thenReturn(Optional.empty());
        when(passwordEncoder.encode(password))
                .thenReturn(encoded);

        userService.save(user);

        User expected = new User(username, encoded, Set.of(role));

        verify(userRepository).findOneByUsername(username);
        verify(passwordEncoder).encode(password);
        verify(userRepository).save(expected);
    }

    @Test
    void findsExistingUser() {

        when(userRepository.findOneByUsername(user.getUsername()))
                .thenReturn(Optional.of(user));

        userService.save(user);

        verify(userRepository).findOneByUsername(user.getUsername());
        verifyNoMoreInteractions(userRepository);
        verifyNoInteractions(passwordEncoder);
    }

    @Test
    void login() {
        String message = userService.login();

        assertEquals(login, message);
    }
}