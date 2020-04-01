package academy.everyonecodes.marathonintegration;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class MarathonClientTest {

    @Autowired
    MarathonClient marathonClient;

    @MockBean
    RestTemplate restTemplate;
    @Value("${marathon.url}")
    String url;

    Runner runner1 = new Runner("Ion", Duration.ofMinutes(3));
    Runner runner2 = new Runner("Vasile", Duration.ofMinutes(7));

    @Test
    void getWinner() {
        marathonClient.getWinner();
        Mockito.verify(restTemplate).getForObject(url + "/runners/winner", Runner.class);
    }

    @Test
    void postRunner() {
        Mockito.when(restTemplate.postForObject(url, runner1, Runner.class)).thenReturn(runner1);

        marathonClient.postRunner(runner1);

        Mockito.verify(restTemplate).postForObject(url + "/runners", runner1, Runner.class);
    }
}