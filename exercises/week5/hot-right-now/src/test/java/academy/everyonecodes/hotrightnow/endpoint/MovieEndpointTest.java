package academy.everyonecodes.hotrightnow.endpoint;

import academy.everyonecodes.hotrightnow.domain.Movie;
import academy.everyonecodes.hotrightnow.logic.MovieStore;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MovieEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    MovieStore movieStore;


    @Test
    void getMovies() {
        String url = "/movies";

        testRestTemplate.getForObject(url, Movie[].class);

        Mockito.verify(movieStore).getHotMovies();
    }
}