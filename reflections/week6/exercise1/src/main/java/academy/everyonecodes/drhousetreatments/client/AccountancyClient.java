package academy.everyonecodes.drhousetreatments.client;

import academy.everyonecodes.drhousetreatments.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class AccountancyClient {
    private final RestTemplate restTemplate;
    private final String url;

    public AccountancyClient(RestTemplate restTemplate, @Value("${accountancy.utl}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public void send(Patient patient) {
        restTemplate.postForObject(url, patient, Void.class);
    }
}
