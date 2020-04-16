package academy.everyonecodes.mongorockscissorspaper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class GameResultManagerTest {

    @Autowired
    GameResultManager gameResultManager;

    @MockBean
    GameResultRepository gameResultRepository;

    @MockBean
    GameRunner gameRunner;

    String result = "test";


    @Test
    void countResult() {
        when(gameResultManager.countResult(result)).thenReturn(1L);

        long times = gameResultManager.countResult(result);

        assertEquals(1L, times);

        verify(gameResultRepository).countByResult(result);
    }

    @Test
    void saveResult() {
        gameResultManager.saveResult(result);
        GameResult gameResult = new GameResult(result);

        assertNull(gameResult.getId());

        verify(gameResultRepository).save(any(GameResult.class));
    }

    @Test
    void deleteAll() {
        gameResultManager.deleteAll();
        verify(gameResultRepository).deleteAll();
    }
}