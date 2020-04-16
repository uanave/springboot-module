package academy.everyonecodes.punchcards;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PunchCardRepository
        extends MongoRepository<PunchCard, String> {
}
