package academy.everyonecodes.marathon;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MarathonService {
    private final Set<Runner> runners = new HashSet<>();

    public void addRunner(Runner runner) {
        runners.add(runner);
    }

    public Optional<Runner> findWinner() {
        return runners.stream().min(Comparator.comparing(Runner::getDuration));
    }

    Set<Runner> getRunners() {
        return runners;
    }
}
