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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TwitterServiceTest {

    @Autowired
    TwitterService twitterService;

    @MockBean
    TweetRepository tweetRepository;

    Tweet tweet = new Tweet();
    String id = "test";

    @Test
    void getAllOrdered() {
        twitterService.getAllOrdered();
        verify(tweetRepository).findAllByOrderByTimestampDesc();
    }

    @Test
    void getTweetsByUser() {
        String user = "test";
        twitterService.getTweetsByUser(user);
        verify(tweetRepository).findByUserOrderByTimestampDesc(user);
    }

    @Test
    void postOne() {
        when(twitterService.postOne(tweet)).thenReturn(tweet);
        Tweet result = twitterService.postOne(tweet);
        Assertions.assertNotNull(result.getTimestamp());
        verify(tweetRepository).save(any(Tweet.class));
    }

    @Test
    void addLike() {
        when(tweetRepository.findById(id)).thenReturn(Optional.of(tweet));
        when(tweetRepository.save(tweet)).thenReturn(tweet);

        twitterService.addLike(id);
        assertEquals(1, tweet.getLikes());

        verify(tweetRepository).findById(id);
        verify(tweetRepository).save(tweet);

    }

    @Test
    void addComment() {
        String comment = "test";
        when(tweetRepository.findById(id))
                .thenReturn(Optional.of(tweet));
        when(tweetRepository.save(tweet))
                .thenReturn(tweet);
        twitterService.addComment(id, comment);
        assertEquals(1, tweet.getComments().size());

        verify(tweetRepository).findById(id);
        verify(tweetRepository).save(tweet);
    }
}