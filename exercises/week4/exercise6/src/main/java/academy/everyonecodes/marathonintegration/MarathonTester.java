package academy.everyonecodes.marathonintegration;

import org.springframework.stereotype.Service;

import java.util.List;

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

        Runner returnedWinner = marathonClient.getWinner();

        if (returnedWinner != null) {
            return new TestResult(
                    "Error", "No winner should have been received in the first call");
        }
        runners
                .forEach(runner -> marathonClient.postRunner(runner));

        returnedWinner = marathonClient.getWinner();
        if (returnedWinner.equals(winner)) {
            return new TestResult("Success", "Tests run correctly");
        }
        return new TestResult("Error", "Incorrect winner received");
    }
}
