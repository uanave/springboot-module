package academy.everyonecodes.recommendations.communication.client;

import academy.everyonecodes.recommendations.domain.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Controller
public class HotRightNowClient {
    private final RestTemplate restTemplate;
    private final String url;

    public HotRightNowClient(RestTemplate restTemplate, @Value("${hot.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public List<Movie> getHotMovies() {
        Movie[] hot = restTemplate.getForObject(url, Movie[].class);
        return List.of(Objects.requireNonNull(hot));
    }
}
