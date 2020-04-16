package academy.everyonecodes.thefinalcountdown;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountdownRepository
        extends MongoRepository<Countdown, String> {
}
