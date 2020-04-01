package academy.everyonecodes.marathonintegration.logic;

import academy.everyonecodes.marathonintegration.communication.client.MarathonClient;
import academy.everyonecodes.marathonintegration.domain.Runner;
import academy.everyonecodes.marathonintegration.domain.TestResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarathonTester {
    private MarathonClient marathonClient;
    private Runner winner;
    private List<Runner> runners;

    public MarathonTester(MarathonClient marathonClient, Runner winner, List<Runner> runners) {
        this.marathonClient = marathonClient;
        this.winner = winner;
        this.runners = runners;
    }

    public TestResult integrate() {
        Optional<Runner> oWinner = marathonClient.getWinner();
        if (oWinner.isPresent()) {
            return new TestResult("Error", "No winner should have been received in the first call");
        }
        runners
                .forEach(marathonClient::postRunner);
        Optional<Runner> oFoundWinner = marathonClient.getWinner();
        if (oFoundWinner.equals(Optional.of(winner))) {
            return new TestResult("Success", "Tests run correctly");
        }
        return new TestResult("Error", "Incorrect winner received");
    }
}
