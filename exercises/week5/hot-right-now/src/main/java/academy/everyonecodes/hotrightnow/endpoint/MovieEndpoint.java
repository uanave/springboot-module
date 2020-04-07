package academy.everyonecodes.hotrightnow.endpoint;

import academy.everyonecodes.hotrightnow.domain.Movie;
import academy.everyonecodes.hotrightnow.logic.MovieStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieEndpoint {
    private final MovieStore movieStore;

    public MovieEndpoint(MovieStore movieStore) {
        this.movieStore = movieStore;
    }

    @GetMapping
    List<Movie> getMovies() {
        return movieStore.getHotMovies();
    }
}
