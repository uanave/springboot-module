package academy.everyonecodes.recommendations.communication.endpoint;

import academy.everyonecodes.recommendations.domain.Movie;
import academy.everyonecodes.recommendations.logic.RecommendationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class RecommendationEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    RecommendationService recommendationService;

    String url = "/recommendations";
    String id = "123";

    @Test
    void getMovies() {
        List<Movie> expected = List.of(new Movie("test", "test"));
        when(recommendationService.recommend(id)).thenReturn(expected);
        Movie[] response = testRestTemplate.getForObject(url + "/" + id, Movie[].class);
        List<Movie> result = List.of(response);
        assertEquals(expected, result);
        verify(recommendationService).recommend(id);
    }
}