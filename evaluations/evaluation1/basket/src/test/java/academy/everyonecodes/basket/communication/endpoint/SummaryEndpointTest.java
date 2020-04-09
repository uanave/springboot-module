package academy.everyonecodes.basket.communication.endpoint;

import academy.everyonecodes.basket.domain.Basket;
import academy.everyonecodes.basket.domain.Summary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class SummaryEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    Basket basket;

    @Test
    void get() {
        String url = "/summaries";

        testRestTemplate.getForObject(url, Summary[].class);

        verify(basket).findAll();
    }
}