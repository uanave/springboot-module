package academy.everyonecodes.hotrightnow.logic;

import academy.everyonecodes.hotrightnow.domain.Movie;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties("hot")
public class MovieStore {
    private List<Movie> movies;

    void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getHotMovies() {
        return movies;
    }
}
