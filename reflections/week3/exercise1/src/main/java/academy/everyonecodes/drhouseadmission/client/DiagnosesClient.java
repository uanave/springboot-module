package academy.everyonecodes.drhouseadmission.client;

import academy.everyonecodes.drhouseadmission.domain.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class DiagnosesClient {
    private final RestTemplate restTemplate;
    private final String url;

    public DiagnosesClient(RestTemplate restTemplate,
                           @Value("${diagnoses.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public Patient send(Patient patient) {
        return restTemplate.postForObject(url + "/", patient, Patient.class);
    }
}
