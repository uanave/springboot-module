package academy.everyonecodes.recommendations.communication.client;

import academy.everyonecodes.recommendations.domain.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TailoredRecommendationsClientTest {
    @Autowired
    TailoredRecommendationsClient client;

    @MockBean
    RestTemplate restTemplate;

    @Value("${tailored.url}")
    String urlTailored;

    @Test
    void getMovies() {
        String uuid = "333ccc";

        List<Movie> expected = List.of(new Movie("test", "test"));

        Mockito.when(restTemplate.getForObject(urlTailored + "/" + uuid, Movie[].class))
                .thenReturn(expected.toArray(Movie[]::new));

        List<Movie> result = client.getMovies(uuid);

        verify(restTemplate).getForObject(urlTailored + "/" + uuid, Movie[].class);
        assertEquals(expected, result);
    }
}