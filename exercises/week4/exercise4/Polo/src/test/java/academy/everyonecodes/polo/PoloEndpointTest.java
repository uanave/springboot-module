package academy.everyonecodes.polo;

import academy.everyonecodes.polo.domain.Polo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PoloEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Polo polo;

    @Test
    void post() {
        String input = "Marco";
        String url = "/polo";
        restTemplate.postForObject(url, input, String.class);
        Mockito.verify(polo).readText(input);
    }
}