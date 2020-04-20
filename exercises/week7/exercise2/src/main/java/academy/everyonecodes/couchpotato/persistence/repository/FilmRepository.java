package academy.everyonecodes.couchpotato.persistence.repository;

import academy.everyonecodes.couchpotato.persistence.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
