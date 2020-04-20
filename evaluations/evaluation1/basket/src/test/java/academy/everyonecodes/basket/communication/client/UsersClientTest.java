package academy.everyonecodes.basket.communication.client;

import academy.everyonecodes.basket.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class UsersClientTest {
    @Autowired
    UsersClient usersClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${clients.url}")
    String url;

    static Stream<Arguments> parameters() {
        User user = new User("found@test.com", "test");
        return Stream.of(
                of(Optional.empty(), null, "not.found@test.com"),
                of(Optional.of(user), user, "found@test.com")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findOneByEmail(Optional<User> oExpected, User user, String email) {
        String oneUserUrl = url + "/" + email;
        when(restTemplate.getForObject(oneUserUrl, User.class))
                .thenReturn(user);

        Optional<User> oResult = usersClient.get(email);

        assertEquals(oExpected, oResult);
        verify(restTemplate).getForObject(oneUserUrl, User.class);
    }
}