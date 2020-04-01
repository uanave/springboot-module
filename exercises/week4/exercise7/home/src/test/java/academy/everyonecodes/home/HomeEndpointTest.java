package academy.everyonecodes.home;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class HomeEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    HomeEndpoint homeEndpoint;

    String url = "/home";

    @Test
    void getMessage() {
        restTemplate.postForObject(url, null, String.class);
        Mockito.verify(homeEndpoint).getMessage();
    }
}