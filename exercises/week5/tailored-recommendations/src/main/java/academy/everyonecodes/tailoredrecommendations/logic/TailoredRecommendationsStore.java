package academy.everyonecodes.tailoredrecommendations.logic;

import academy.everyonecodes.tailoredrecommendations.domain.Movie;
import academy.everyonecodes.tailoredrecommendations.domain.TailoredRecommendation;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("tailoredrecommendations")
public class TailoredRecommendationsStore {

    private List<TailoredRecommendation> recommendations;

    void setRecommendations(List<TailoredRecommendation> recommendations) {
        this.recommendations = recommendations;
    }

    List<TailoredRecommendation> getAll() {
        return recommendations;
    }

    public List<Movie> getMoviesById(String uuid) {
        return recommendations.stream()
                .filter(recommendation -> recommendation.getUserUuid().equalsIgnoreCase(uuid))
                .map(TailoredRecommendation::getMovie)
                .collect(Collectors.toList());
    }

    public TailoredRecommendation postOne(TailoredRecommendation recommendation) {
        recommendations.add(recommendation);
        return recommendation;
    }

}
