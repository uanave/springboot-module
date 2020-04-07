package academy.everyonecodes.recommendations.communication.endpoint;

import academy.everyonecodes.recommendations.domain.Movie;
import academy.everyonecodes.recommendations.logic.RecommendationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class RecommendationEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    RecommendationService recommendationService;

    String url = "/recommendations";

    @Test
    void getMovies() {
        String id = "123";

        testRestTemplate.getForObject(url + "/" + id, Movie[].class);
        verify(recommendationService).recommend(id);
    }
}