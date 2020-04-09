package academy.everyonecodes.basket.communication.client;

import academy.everyonecodes.basket.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class UsersClientTest {
    @Autowired
    UsersClient usersClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${clients.url}")
    String url;

    @Test
    void get() {
        String email = "test";

        usersClient.get(email);

        verify(restTemplate).getForObject(url + "/" + email, User.class);
    }
}