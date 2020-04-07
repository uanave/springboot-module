package academy.everyonecodes.recommendations.communication.client;

import academy.everyonecodes.recommendations.domain.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Controller
@Order(2)
public class TailoredRecommendationsClient {
    private final RestTemplate restTemplate;
    private final String urlTailored;

    public TailoredRecommendationsClient(RestTemplate restTemplate, @Value("${tailored.url}") String urlTailored) {
        this.restTemplate = restTemplate;
        this.urlTailored = urlTailored;
    }

    public List<Movie> getMovies(String uuid) {
        Movie[] response = restTemplate.getForObject(urlTailored + "/" + uuid, Movie[].class);
        return List.of(Objects.requireNonNull(response));
    }

}
