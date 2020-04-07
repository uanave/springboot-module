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
    void getTailored() {
        when(tailoredRecommendationsClient.getMovies(uuid)).thenReturn(movies);

        List<Movie> result = recommendationService.recommend(uuid);

        assertEquals(movies, result);
        verify(tailoredRecommendationsClient).getMovies(uuid);
        verify(hotRightNowClient, never()).getHotMovies();

    }

    @Test
    void recommendHot() {
        when(tailoredRecommendationsClient.getMovies(uuid)).thenReturn(List.of());
        when(hotRightNowClient.getHotMovies()).thenReturn(movies);

        List<Movie> result = recommendationService.recommend(uuid);

        assertEquals(movies, result);
        verify(hotRightNowClient).getHotMovies();
        verify(tailoredRecommendationsClient).getMovies(uuid);
    }
}