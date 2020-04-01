package academy.everyonecodes.marathonintegration.communication.client;

import academy.everyonecodes.marathonintegration.domain.Runner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Controller
public class MarathonClient {
    private final RestTemplate restTemplate;
    private final String url;

    public MarathonClient(RestTemplate restTemplate,
                          @Value("${marathon.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public Optional<Runner> getWinner() {
        return Optional.ofNullable(restTemplate.getForObject(url + "/runners/winner", Runner.class));
    }

    public void postRunner(Runner runner) {
        restTemplate.postForObject(url + "/runners", runner, Runner.class);
    }
}
