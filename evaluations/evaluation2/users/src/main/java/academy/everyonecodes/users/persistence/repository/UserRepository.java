package academy.everyonecodes.users.persistence.repository;

import academy.everyonecodes.users.persistence.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findOneByUsername(String username);

    boolean existsByUsername(String username);
}
