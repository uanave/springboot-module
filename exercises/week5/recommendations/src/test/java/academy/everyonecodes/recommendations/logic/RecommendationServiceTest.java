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


    @Test
    void recommendTailored() {
        String id = "123";
        List<Movie> tailored = List.of(new Movie("test", "test"));
        List<Movie> hot = List.of(new Movie("test1", "test1"));

        when(hotRightNowClient.getHotMovies()).thenReturn(hot);
        when(tailoredRecommendationsClient.getMovies(id)).thenReturn(tailored);


        List<Movie> result = recommendationService.recommend(id);

        verify(tailoredRecommendationsClient).getMovies(id);
        verify(hotRightNowClient, never()).getHotMovies();
        assertEquals(tailored, result);
    }
    @Test
    void recommendHot() {
        String id = "123";
        List<Movie> hot = List.of(new Movie("test1", "test1"));

        when(hotRightNowClient.getHotMovies()).thenReturn(hot);


        List<Movie> result = recommendationService.recommend(id);

        verify(hotRightNowClient).getHotMovies();
        assertEquals(hot, result);
    }
}