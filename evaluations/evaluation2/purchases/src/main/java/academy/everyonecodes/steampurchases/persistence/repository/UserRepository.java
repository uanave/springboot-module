package academy.everyonecodes.steampurchases.persistence.repository;

import academy.everyonecodes.steampurchases.persistence.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByUsername(String username);
}
