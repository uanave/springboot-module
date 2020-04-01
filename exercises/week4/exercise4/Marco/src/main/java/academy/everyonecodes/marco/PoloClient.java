package academy.everyonecodes.marco;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class PoloClient {
    private final RestTemplate restTemplate;
    private final String messageUrl;

    public PoloClient(RestTemplate restTemplate,
                      @Value("${polo.url}") String messageUrl) {
        this.restTemplate = restTemplate;
        this.messageUrl = messageUrl;
    }

    public String post(String message) {
        return restTemplate.postForObject(messageUrl, message, String.class);
    }
}
