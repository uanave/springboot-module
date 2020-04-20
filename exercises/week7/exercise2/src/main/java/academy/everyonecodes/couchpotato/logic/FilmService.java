package academy.everyonecodes.couchpotato.logic;

import academy.everyonecodes.couchpotato.persistence.domain.Film;
import academy.everyonecodes.couchpotato.persistence.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> findAll() {
       return filmRepository.findAll();
    }

    public Film save(Film film) {
        return filmRepository.save(film);
    }
}
