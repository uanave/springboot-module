package academy.everyonecodes.mongorockscissorspaper;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameResultRepository
        extends MongoRepository<GameResult, String> {

    long countByResult(String result);
}
