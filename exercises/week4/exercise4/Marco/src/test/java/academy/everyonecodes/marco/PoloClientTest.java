package academy.everyonecodes.marco;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PoloClientTest {

    @Autowired
    PoloClient poloClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${polo.url}")
    String messageUrl;


    @Test
    void post() {
        String message = "Marco";
//        Mockito.when(restTemplate.postForObject(messageUrl, message, String.class)).thenReturn("Polo");

        poloClient.post(message);

        Mockito.verify(restTemplate).postForObject(messageUrl, message, String.class);
    }
}