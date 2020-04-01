package academy.everyonecodes.dorothy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class Dorothy {
    private final RestTemplate restTemplate;
    private final String urlWizard;

    public Dorothy(RestTemplate restTemplate,
                   @Value("${interactions.wizard}") String urlWizard) {
        this.restTemplate = restTemplate;
        this.urlWizard = urlWizard;
    }

    public String interract() {
        String homeUrl = restTemplate.postForObject(urlWizard, null, String.class);
        return restTemplate.postForObject(homeUrl, null, String.class);

    }

}
