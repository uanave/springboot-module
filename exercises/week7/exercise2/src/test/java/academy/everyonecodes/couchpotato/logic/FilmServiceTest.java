package academy.everyonecodes.couchpotato.logic;

import academy.everyonecodes.couchpotato.persistence.domain.Film;
import academy.everyonecodes.couchpotato.persistence.repository.FilmRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class FilmServiceTest {

    @Autowired
    FilmService filmService;

    @MockBean
    FilmRepository filmRepository;

    @Test
    void findAll() {
        filmService.findAll();

        verify(filmRepository).findAll();
    }

    @Test
    void save() {
        Film film = new Film("Spiderman", 4);
        filmService.save(film);
        verify(filmRepository).save(film);
    }
}