package academy.everyonecodes.punchcards;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class PunchCardServiceTest {

    @Autowired
    PunchCardService punchCardService;

    @MockBean
    PunchCardRepository punchCardRepository;

    @MockBean
    PunchCardRunner runner;

    @Test
    void save() {
//        PunchCard punchCard = new PunchCard("MONDAY", "14:08:51");
//        when(punchCardRepository.save(punchCard)).thenReturn(punchCard);
        PunchCard punchCard = new PunchCard(LocalDateTime.now().getDayOfWeek().toString(), LocalTime.now().toString());
        assertNull(punchCard.getId());
//        PunchCard result = punchCardService.save(punchCard);
//        assertEquals(punchCard, result);
        punchCardService.punch();

        verify(punchCardRepository).save(any(PunchCard.class));
//        verify(runner).runPunchCards(punchCardService);
    }
}