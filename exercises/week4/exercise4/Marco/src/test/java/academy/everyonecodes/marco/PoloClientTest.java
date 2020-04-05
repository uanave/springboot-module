package academy.everyonecodes.marco;

import academy.everyonecodes.marco.communication.client.PoloClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        String expected = "Marco";
        when(restTemplate.postForObject(messageUrl, message, String.class)).thenReturn(expected);

        String response = poloClient.post(message);

        assertEquals(expected, response);
        verify(restTemplate).postForObject(messageUrl, message, String.class);
    }
}