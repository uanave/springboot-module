package academy.everyonecodes.wizard;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class WizardEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    WizardEndpoint wizardEndpoint;

    String url = "/wizard";

    @Test
    void post() {
        restTemplate.postForObject(url, null, String.class);
        Mockito.verify(wizardEndpoint).post();
    }
}