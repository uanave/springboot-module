package academy.everyonecodes.tailoredrecommendations.endpoint;


import academy.everyonecodes.tailoredrecommendations.domain.Movie;
import academy.everyonecodes.tailoredrecommendations.domain.TailoredRecommendation;
import academy.everyonecodes.tailoredrecommendations.logic.TailoredRecommendationsStore;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tailoredrecommendations")
public class TailoredRecommendationsEndpoint {

    private final TailoredRecommendationsStore tailoredRecommendationsStore;

    public TailoredRecommendationsEndpoint(TailoredRecommendationsStore tailoredRecommendationsStore) {
        this.tailoredRecommendationsStore = tailoredRecommendationsStore;
    }

    @PostMapping
    TailoredRecommendation post(@RequestBody TailoredRecommendation recommendation) {
        return tailoredRecommendationsStore.postOne(recommendation);
    }

    @GetMapping("/{userUuid}")
    List<Movie> getById(@PathVariable String userUuid) {
        return tailoredRecommendationsStore.getMoviesById(userUuid);
    }
}
