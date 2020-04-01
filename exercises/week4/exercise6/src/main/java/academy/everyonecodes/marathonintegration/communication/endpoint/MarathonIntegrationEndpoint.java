package academy.everyonecodes.marathonintegration.communication.endpoint;

import academy.everyonecodes.marathonintegration.logic.MarathonTester;
import academy.everyonecodes.marathonintegration.domain.TestResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marathon")
public class MarathonIntegrationEndpoint {
    private final MarathonTester marathonTester;

    public MarathonIntegrationEndpoint(MarathonTester marathonTester) {
        this.marathonTester = marathonTester;
    }

    @GetMapping("/integration")
    TestResult get() {
        return marathonTester.integrate();
    }
}
