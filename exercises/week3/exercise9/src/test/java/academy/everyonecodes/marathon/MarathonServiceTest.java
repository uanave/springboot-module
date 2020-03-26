package academy.everyonecodes.marathon;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarathonServiceTest {
    private Set<Runner> runners = new HashSet<>();
    MarathonService marathonService = new MarathonService(runners);
    private Runner runner1 = new Runner("John", Duration.ofSeconds(130));
    private Runner runner2 = new Runner("Emil", Duration.ofSeconds(120));
    private Runner runner3 = new Runner("Dan", Duration.ofMillis(118500));

    @Test
    void add() {
        marathonService.addRunner(runner1);
        marathonService.addRunner(runner2);

        Set<Runner> result = marathonService.getRunners();

        Set<Runner> expected = Set.of(runner1, runner2);
        assertEquals(expected, result);
    }

    @Test
    void findWinner() {
        marathonService.addRunner(runner1);
        marathonService.addRunner(runner2);
        marathonService.addRunner(runner3);

        Optional<Runner> result = marathonService.findWinner();

        Runner expected = runner3;
        assertEquals(expected.hashCode(), result.hashCode());
    }

    @Test
    void getRunners() {
        marathonService.addRunner(runner1);
        marathonService.addRunner(runner2);

        Set<Runner> result = marathonService.getRunners();

        Set<Runner> expected = Set.of(runner1, runner2);
        assertEquals(expected, result);
    }
}