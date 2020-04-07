package academy.everyonecodes.recommendations.communication.endpoint;

import academy.everyonecodes.recommendations.domain.Movie;
import academy.everyonecodes.recommendations.logic.RecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationEndpoint {
    private final RecommendationService recommendationService;

    public RecommendationEndpoint(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/{user}")
    List<Movie> getMovies(@PathVariable String user) {
        return recommendationService.recommend(user);
    }
}
