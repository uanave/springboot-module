package academy.everyonecodes.trickster.logic;

import academy.everyonecodes.trickster.communication.client.CupsClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TricksterTest {

    @Autowired
    Trickster trickster;

    @MockBean
    CupsClient cupsClient;

    @MockBean
    Random random;

    @Test
    void startGame() {
        String result = trickster.startGame();
        String expected = "The cups have been shuffled!";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void hasCoin() {
        int number = 2;
        Boolean is = cupsClient.hasCoin(number);
        assertFalse(is);
    }
}