package academy.everyonecodes.dorothy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DorothyTest {

    @Autowired
    Dorothy dorothy;

    @MockBean
    RestTemplate restTemplate;
    @Value("${wizard.url}")
    String url;

    @Test
    void interact() {
        String homeUrl = "home";
        String homeMessage = "homeMessage";

        when(restTemplate.getForObject(url, String.class)).thenReturn(homeUrl);

        when(restTemplate.getForObject(homeUrl, String.class)).thenReturn(homeMessage);

        String result = dorothy.interact();

        String expected = "My home is " + homeMessage;

        assertEquals(expected, result);
    }
}