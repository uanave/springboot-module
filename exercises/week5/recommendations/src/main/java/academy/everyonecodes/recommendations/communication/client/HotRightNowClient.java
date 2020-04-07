package academy.everyonecodes.recommendations.communication.client;

import academy.everyonecodes.recommendations.domain.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Controller
@Order(1)
public class HotRightNowClient {
    private final RestTemplate restTemplate;
    private final String urlHot;

    public HotRightNowClient(RestTemplate restTemplate, @Value("${hot.url}") String urlHot) {
        this.restTemplate = restTemplate;
        this.urlHot = urlHot;
    }

    public List<Movie> getHotMovies() {
        Movie[] hot = restTemplate.getForObject(urlHot, Movie[].class);
        return List.of(Objects.requireNonNull(hot));
    }
}
