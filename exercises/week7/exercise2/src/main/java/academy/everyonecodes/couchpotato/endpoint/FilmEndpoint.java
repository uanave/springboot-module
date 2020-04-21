package academy.everyonecodes.couchpotato.endpoint;

import academy.everyonecodes.couchpotato.logic.FilmService;
import academy.everyonecodes.couchpotato.persistence.domain.Film;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmEndpoint {
    private final FilmService filmService;

    public FilmEndpoint(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    List<Film> getAll() {
        return filmService.findAll();
    }

    @PostMapping
    Film saveOne(@Valid @RequestBody Film film) {
        return filmService.save(film);
    }
}
