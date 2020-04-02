package academy.everyonecodes.cup.endpoint;

import academy.everyonecodes.cup.logic.Cup;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class CupEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Cup cup;

    String url = "/cup";

    @Test
    void get() {
        restTemplate.getForObject(url, Boolean.class);
        Mockito.verify(cup).hasCoin();
    }

    @Test
    void put() {
        restTemplate.put(url, Boolean.class);
        Mockito.verify(cup).putCoin();
    }

    @Test
    void delete() {
        restTemplate.delete(url, Boolean.class);
        Mockito.verify(cup).removeCoin();
    }
}