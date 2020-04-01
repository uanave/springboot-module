package academy.everyonecodes.dorothy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class Dorothy {
    private final RestTemplate restTemplate;
    private final String urlWizard;

    public Dorothy(RestTemplate restTemplate,
                   @Value("${wizard.url}") String urlWizard) {
        this.restTemplate = restTemplate;
        this.urlWizard = urlWizard;
    }

    public String interact() {
        String homeUrl = restTemplate.getForObject(urlWizard, String.class);
        return "My home is " + restTemplate.getForObject(homeUrl, String.class);
    }
}
