package academy.everyonecodes.authorizedmarco.communication.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class PoloClientTest {

    @Autowired
    PoloClient poloClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${polo.url}")
    String url;

    @Test
    void post() {
        String text = "test";
        poloClient.post(text);
        verify(restTemplate).postForObject(url, text, String.class);
    }
}