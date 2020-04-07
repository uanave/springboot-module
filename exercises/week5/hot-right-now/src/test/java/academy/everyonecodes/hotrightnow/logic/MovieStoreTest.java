package academy.everyonecodes.hotrightnow.logic;

import academy.everyonecodes.hotrightnow.domain.Movie;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class MovieStoreTest {

    @Autowired
    MovieStore movieStore;

    @Test
    void getMovies() {
        List<Movie> result = movieStore.getMovies();
        List<Movie> expected = List.of(
                new Movie("test1", "test1"),
                new Movie("test2", "test2")
        );
        assertEquals(expected, result);
    }
}