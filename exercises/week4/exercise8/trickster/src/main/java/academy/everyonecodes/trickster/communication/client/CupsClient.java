package academy.everyonecodes.trickster.communication.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class CupsClient {
    private final RestTemplate restTemplate;
    private final List<String> urls;

    public CupsClient(RestTemplate restTemplate,
                      @Value("${url.cups}") List<String> urls) {
        this.restTemplate = restTemplate;
        this.urls = urls;
    }

    public Boolean hasCoin(int cupNumber) {
        return restTemplate.getForObject(urls.get(cupNumber), Boolean.class);
    }

    public void placeCoin(int cupNumber) {
        restTemplate.put(urls.get(cupNumber), Boolean.class);
    }

    public void removeCoin(int cupNumber) {
        restTemplate.delete(urls.get(cupNumber));
    }

    public int getCups() {
        return urls.size();
    }
}
