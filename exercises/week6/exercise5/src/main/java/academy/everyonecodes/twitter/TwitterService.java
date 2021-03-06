package academy.everyonecodes.twitter;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TwitterService {
    private final TweetRepository tweetRepository;

    public TwitterService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public List<Tweet> getAllOrdered() {
        return tweetRepository.findAllByOrderByTimestampDesc();
    }

    public List<Tweet> getTweetsByUser(String user) {
        return tweetRepository.findByUserOrderByTimestampDesc(user);
    }

    public Tweet postOne(Tweet tweet) {
        tweet.setTimestamp(LocalDateTime.now());
        tweetRepository.save(tweet);
        return tweet;
    }

    public void addLike(String id) {
        Optional<Tweet> found = tweetRepository.findById(id);
        found.ifPresent(tweet -> tweet.setLikes(tweet.getLikes() + 1));
        found.ifPresent(tweetRepository::save);
    }

    public void addComment(String id, String comment) {
        Optional<Tweet> oFound = tweetRepository.findById(id);
        oFound.ifPresent(tweet -> tweet.getComments().add(comment));
        oFound.ifPresent(tweetRepository::save);
    }
}
