package academy.everyonecodes.socialnetwork.repository;

import academy.everyonecodes.socialnetwork.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
