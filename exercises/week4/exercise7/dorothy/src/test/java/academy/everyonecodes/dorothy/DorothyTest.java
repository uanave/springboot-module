package academy.everyonecodes.dorothy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DorothyTest {

    @Autowired
    Dorothy dorothy;

    @MockBean
    RestTemplate restTemplate;
    @Value("${interactions.wizard}")
    String urlWizard;

    @Test
    void interract() {
        dorothy.interract();
        Mockito.verify(restTemplate).postForObject(urlWizard, null, String.class);
    }
}