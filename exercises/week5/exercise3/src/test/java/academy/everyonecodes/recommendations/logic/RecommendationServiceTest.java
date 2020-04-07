package academy.everyonecodes.recommendations.logic;

import academy.everyonecodes.recommendations.communication.client.HotRightNowClient;
import academy.everyonecodes.recommendations.communication.client.TailoredRecommendationsClient;
import academy.everyonecodes.recommendations.domain.Movie;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class RecommendationServiceTest {
    @Autowired
    RecommendationService recommendationService;

    @MockBean
    TailoredRecommendationsClient tailoredRecommendationsClient;

    @MockBean
    HotRightNowClient hotRightNowClient;



    @Test
    void recommend() {
        String id = "test";
        recommendationService.recommend(id);
//        verify(tailoredRecommendationsClient.getMovies(id));
        verify(hotRightNowClient).getHotMovies();

    }
}