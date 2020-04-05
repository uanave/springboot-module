package academy.everyonecodes.marco;

import academy.everyonecodes.marco.communication.client.PoloClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MarcoEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    PoloClient poloClient;

    String url = "/marco";


    @Test
    void get() {
        String message = "message";
        String expected = "answer";
        when(poloClient.post(message)).thenReturn(expected);

        String response = restTemplate.getForObject(url + "/" + message, String.class);

        assertEquals(expected, response);
        verify(poloClient).post(message);
    }

}