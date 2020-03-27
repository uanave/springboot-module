package academy.everyonecodes.marathon;

import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/runners")
public class MarathonEndpoint {
    private final MarathonService marathonService;

    public MarathonEndpoint(MarathonService marathonService) {
        this.marathonService = marathonService;
    }

    @GetMapping
    Set<Runner> getRunners() {
        return marathonService.getRunners();
    }

    @PostMapping
    Runner post(@RequestBody Runner runner) {
        marathonService.addRunner(runner);
        return runner;
    }

    @GetMapping("/winner")
    Runner winner() {
        return marathonService.findWinner()
                .orElse(null);
    }
}
