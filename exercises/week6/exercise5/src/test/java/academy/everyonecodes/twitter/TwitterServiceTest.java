package academy.everyonecodes.twitter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TwitterServiceTest {

    @Autowired
    TwitterService twitterService;

    @MockBean
    TweetRepository tweetRepository;

    @Test
    void getAllOrdered() {
        List<Tweet> result = twitterService.getAllOrdered();
        Assertions.assertNotNull(result);
        verify(tweetRepository).findAllByOrderByTimestampDesc();
    }

    @Test
    void getTweetsByUser() {
        String user = "test";
        Mockito.when(twitterService.getTweetsByUser(user)).thenReturn(List.of());
        List<Tweet> result = tweetRepository.findByUserOrderByTimestampDesc(user);
        List<Tweet> expected = List.of();
        Assertions.assertEquals(expected, result);
        verify(tweetRepository).findByUserOrderByTimestampDesc(user);
    }

    @Test
    void postOne() {
        Tweet tweet = new Tweet();
        Mockito.when(twitterService.postOne(tweet)).thenReturn(tweet);
        Tweet result = twitterService.postOne(tweet);
        Assertions.assertNotNull(result.getTimestamp());
        verify(tweetRepository).save(any(Tweet.class));
    }

    @Test
    void addLike() {
        String id = "test";
        twitterService.addLike(id);
//        Optional<Tweet> oTweet = tweetRepository.findById(id);
//        oTweet.ifPresent(tweet -> Assertions.assertTrue(tweet.getLikes()>0));
        verify(tweetRepository).findById(id);

//        verify(tweetRepository).save(any(Tweet.class));
    }

    @Test
    void addComment() {
        String id = "test";
        twitterService.addLike(id);
        verify(tweetRepository).findById(id);
    }
}