package academy.everyonecodes.users.endpoint;

import academy.everyonecodes.users.domain.User;
import academy.everyonecodes.users.logic.UserStore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UserEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    UserStore userStore;

    String url = "/users";

    @Test
    void find() {
        String email = "email";

        testRestTemplate.getForObject(url + "/" + email, User.class);

        verify(userStore).find(email);
    }
}