package academy.everyonecodes.twitter;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TweetRepository extends MongoRepository<Tweet, String> {
    List<Tweet> findAllByOrderByTimestampDesc();

    List<Tweet> findByUserOrderByTimestampDesc(String user);
}
