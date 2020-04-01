package academy.everyonecodes.dorothy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class DorothyEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Dorothy dorothy;

    @Test
    void getResponse() {
        String url = "/dorothy";

        restTemplate.getForObject(url, String.class);
        Mockito.verify(dorothy).interract();
    }
}