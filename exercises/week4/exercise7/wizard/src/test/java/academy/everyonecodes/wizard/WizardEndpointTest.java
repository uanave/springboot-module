package academy.everyonecodes.wizard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class WizardEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Value("${home.url}")
    String home;

    @Test
    void post() {
        String url = "/wizard";

        String response = restTemplate.getForObject(url, String.class);
        Assertions.assertEquals(home, response);
    }
}