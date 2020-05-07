package academy.everyonecodes.steampurchases.persistence.repository;

import academy.everyonecodes.steampurchases.persistence.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findOneByIdentifier(String identifier);
}
