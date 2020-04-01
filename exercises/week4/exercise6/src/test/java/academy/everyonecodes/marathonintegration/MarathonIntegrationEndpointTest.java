package academy.everyonecodes.marathonintegration;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MarathonIntegrationEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    MarathonTester marathonTester;

    @Test
    void get() {
        String url = "/marathon/integration";

        restTemplate.getForObject(url, TestResult.class);

        Mockito.verify(marathonTester).integrate();
    }
}