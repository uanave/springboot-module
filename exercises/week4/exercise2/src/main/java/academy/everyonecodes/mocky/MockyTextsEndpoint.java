package academy.everyonecodes.mocky;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/mocky/texts")
public class MockyTextsEndpoint {
    private final RestTemplate restTemplate;
    private final String one;
    private final String more;

    public MockyTextsEndpoint(RestTemplate restTemplate,
                              @Value("${mocky.url.texts.one}") String one,
                              @Value("${mocky.url.texts.two}") String more) {
        this.restTemplate = restTemplate;
        this.one = one;
        this.more = more;
    }

    @GetMapping("/1")
    String getOne() {
        return restTemplate.getForObject(one, String.class);
    }

    @GetMapping("/2")
    List<String> getTwo() {
        String[] response = restTemplate.getForObject(more, String[].class);
        return List.of(response);
    }
}
