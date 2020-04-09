package academy.everyonecodes.users.logic;

import academy.everyonecodes.users.domain.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class UserStoreTest {

    @Autowired
    UserStore userStore;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(Optional.empty(),
                        List.of(new User("test", "test", "test")), "email@email.com"),
                Arguments.of(Optional.of(
                        new User("test", "test", "test")),
                        List.of(new User("test", "test", "test")), "test"),
                Arguments.of(Optional.empty(),
                        List.of(new User("test", "test", "test")), "")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void find(Optional<User> expected, List<User> users, String email) {
        Optional<User> result = userStore.find(email);

        assertEquals(expected, result);
    }
}