package academy.everyomecodes.drhousediagnoses.client;

import academy.everyomecodes.drhousediagnoses.domain.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class TreatmentsClient {
    private final RestTemplate restTemplate;
    private final String url;

    public TreatmentsClient(RestTemplate restTemplate, @Value("${treatments.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public void send(Patient patient) {
        restTemplate.postForObject(url, patient, Void.class);
    }
}
