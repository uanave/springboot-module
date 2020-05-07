package academy.everyonecodes.steampurchases.endpoint;

import academy.everyonecodes.steampurchases.persistence.domain.Game;
import academy.everyonecodes.steampurchases.logic.PurchaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class GamesEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    PurchaseService purchaseService;

    @Test
    void getAllGames() {
        String url = "/games";

        testRestTemplate.getForObject(url, Game[].class);

        verify(purchaseService).findAllGames();
    }
}