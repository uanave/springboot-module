package academy.everyonecodes.recommendations.communication.client;

import academy.everyonecodes.recommendations.domain.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class HotRightNowClientTest {

    @Autowired
    HotRightNowClient hotRightNowClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${hot.url}")
    String url;

    @Test
    void getHotMovies() {
        List<Movie> expected = List.of(new Movie("test", "test"));

        when(restTemplate.getForObject(url, Movie[].class))
                .thenReturn(expected.toArray(Movie[]::new));

        List<Movie> result = hotRightNowClient.getHotMovies();

        verify(restTemplate).getForObject(url, Movie[].class);
        assertEquals(expected, result);
    }
}
