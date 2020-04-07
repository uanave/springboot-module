package academy.everyonecodes.recommendations.logic;

import academy.everyonecodes.recommendations.communication.client.HotRightNowClient;
import academy.everyonecodes.recommendations.communication.client.TailoredRecommendationsClient;
import academy.everyonecodes.recommendations.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {
    private final TailoredRecommendationsClient tailoredClient;
    private final HotRightNowClient hotClient;

    public RecommendationService(TailoredRecommendationsClient tailoredClient, HotRightNowClient hotClient) {
        this.tailoredClient = tailoredClient;
        this.hotClient = hotClient;
    }

    public List<Movie> recommend(String user) {
        List<Movie> tailored = tailoredClient.getMovies(user);
        if (!tailored.isEmpty()) {
            return tailored;
        }
        return hotClient.getHotMovies();
    }
}
