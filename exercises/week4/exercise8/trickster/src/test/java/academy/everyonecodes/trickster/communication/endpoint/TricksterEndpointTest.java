package academy.everyonecodes.trickster.communication.endpoint;

import academy.everyonecodes.trickster.logic.Trickster;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TricksterEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    Trickster trickster;

    @Test
    void play() {
        String url = "/play";
        testRestTemplate.getForObject(url, String.class);
        Mockito.verify(trickster).startGame();
    }

    @Test
    void choose() {
        String url = "/choose/1";

        int input = 1;

        Mockito.when(trickster.hasCoin(input)).thenReturn(true);

        testRestTemplate.getForObject(url, Boolean.class);
        Mockito.verify(trickster).hasCoin(input);
    }
}