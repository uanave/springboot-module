package academy.everyonecodes.tailoredrecommendations.endpoint;

import academy.everyonecodes.tailoredrecommendations.domain.Movie;
import academy.everyonecodes.tailoredrecommendations.domain.TailoredRecommendation;
import academy.everyonecodes.tailoredrecommendations.logic.TailoredRecommendationsStore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TailoredRecommendationsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    TailoredRecommendationsStore tailoredRecommendationsStore;

    String url = "/tailoredrecommendations";


    @Test
    void postOne() {
        TailoredRecommendation tailoredRecommendation = new TailoredRecommendation("3", new Movie("test3", "test3"));

        testRestTemplate.postForObject(url, tailoredRecommendation, TailoredRecommendation.class);

        verify(tailoredRecommendationsStore).postOne(tailoredRecommendation);
    }

    @Test
    void getById() {
        String id = "1";

        testRestTemplate.getForObject(url + "/" + id, Movie[].class);

        verify(tailoredRecommendationsStore).getMoviesById(id);
    }
}