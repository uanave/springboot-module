package academy.everyonecodes.recommendations.logic;

import academy.everyonecodes.recommendations.communication.client.HotRightNowClient;
import academy.everyonecodes.recommendations.communication.client.TailoredRecommendationsClient;
import academy.everyonecodes.recommendations.domain.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class RecommendationServiceTest {
    @Autowired
    RecommendationService recommendationService;

    @MockBean
    TailoredRecommendationsClient tailoredRecommendationsClient;

    @MockBean
    HotRightNowClient hotRightNowClient;

    String uuid = "123";
    List<Movie> movies = List.of(new Movie("test", "test"));

    @Test
    void recommendTailored() {
        when(tailoredRecommendationsClient.getMovies(uuid)).thenReturn(movies);

        List<Movie> result = recommendationService.recommend(uuid);

        verify(tailoredRecommendationsClient).getMovies(uuid);
        verify(hotRightNowClient, never()).getHotMovies();
        assertEquals(movies, result);

    }

    @Test
    void recommendHot() {
        when(hotRightNowClient.getHotMovies()).thenReturn(movies);

        List<Movie> result = recommendationService.recommend(uuid);

        verify(hotRightNowClient).getHotMovies();
        assertEquals(movies, result);
    }
}