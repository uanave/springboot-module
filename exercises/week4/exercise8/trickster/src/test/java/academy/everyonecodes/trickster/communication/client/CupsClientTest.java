package academy.everyonecodes.trickster.communication.client;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class CupsClientTest {

    @Autowired
    CupsClient cupsClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${url.cups}")
    List<String> urls;

    int number = 2;

    @Test
    void hasCoin() {
        cupsClient.hasCoin(number);
        Mockito.verify(restTemplate).getForObject(urls.get(number), Boolean.class);
    }

    @Test
    void placeCoin() {
        cupsClient.placeCoin(number);
        Mockito.verify(restTemplate).put(urls.get(number), Boolean.class);
    }

    @Test
    void removeCoin() {
        cupsClient.removeCoin(number);
        Mockito.verify(restTemplate).delete(urls.get(number));
    }

    @Test
    void getCups() {
        int result = cupsClient.getCups();

        int expected = 3;
        assertEquals(expected, result);
    }
}