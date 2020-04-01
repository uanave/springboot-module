package academy.everyonecodes.wizard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class WizardEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void post() {
        String url = "/wizard";

        restTemplate.getForObject(url, String.class);
    }
}