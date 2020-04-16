//package academy.everyonecodes.thefinalcountdown;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.List;
//
//import static org.mockito.Mockito.never;
//import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;
//
//@SpringBootTest(webEnvironment = NONE)
//class CountdownManagerTest {
//
//    @Autowired
//    CountdownManager countdownManager;
//
//    @MockBean
//    CountdownRepository countdownRepository;
//
//    @MockBean
//    AccumulationManager accumulationManager;
//
//    @MockBean
//    TheFinalCountdownRunner theFinalCountdownRunner;
//
//    @Value("${countdown.start}")
//    int countdownStart;
//
//    @Test
//    void countCreatesCountdown() {
//        countdownManager.countdown();
//
//        Mockito.verify(countdownRepository).count();
//        Countdown countdown = new Countdown(countdownStart);
//        Mockito.verify(countdownRepository).save(countdown);
//        Mockito.verify(countdownRepository, never()).findAll();
//        Mockito.verify(countdownRepository, never()).delete(countdown);
//        Mockito.verify(accumulationManager, never()).accumulate();
//    }
//
//    @Test
//    void countReducesCountdown() {
//        Countdown countdown1 = new Countdown(2);
//        Mockito.when(countdownRepository.count())
//                .thenReturn(1L);
//        Mockito.when(countdownRepository.findAll())
//                .thenReturn(List.of(countdown1));
//
//        countdownManager.countdown();
//
//        Mockito.verify(countdownRepository).count();
//        Mockito.verify(countdownRepository).findAll();
//        Countdown countdown2 = new Countdown(1);
//        Mockito.verify(countdownRepository).save(countdown2);
//        Mockito.verify(countdownRepository, never()).delete(countdown2);
//        Mockito.verify(accumulationManager, never()).accumulate();
//    }
//
//    @Test
//    void countRemovesCountdown() {
//        Countdown countdown1 = new Countdown(1);
//        Mockito.when(countdownRepository.count())
//                .thenReturn(1L);
//        Mockito.when(countdownRepository.findAll())
//                .thenReturn(List.of(countdown1));
//
//        countdownManager.countdown();
//
//        Mockito.verify(countdownRepository).count();
//        Mockito.verify(countdownRepository).findAll();
//        Countdown countdown2 = new Countdown(0);
//        Mockito.verify(countdownRepository, never()).save(countdown2);
//        Mockito.verify(countdownRepository).delete(countdown2);
//        Mockito.verify(accumulationManager).accumulate();
//    }
//}
//
//
