package academy.everyonecodes.twitter;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TweetsEndpointTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    TwitterService twitterService;

    String url = "/tweets";

    @Test
    void getAllOrdered() {
        testRestTemplate.getForObject(url, Tweet[].class);
        verify(twitterService).getAllOrdered();
    }

    @Test
    void getByUser() {
        String name = "test";
        testRestTemplate.getForObject(url + "/user/" + name, Tweet[].class);
        verify(twitterService).getTweetsByUser(name);
    }

    @Test
    void postOne() {
        Tweet tweet = new Tweet();
        testRestTemplate.postForObject(url, tweet, Tweet.class);
        verify(twitterService).postOne(tweet);
    }

    @Test
    void addLike() {
        String id = "test";
        testRestTemplate.put(url + "/" + id + "/likes", String.class);
        verify(twitterService).addLike(id);
    }

    @Test
    void addComment() {
        String id = "test";
        String comment = "etc";
        testRestTemplate.put(url + "/" + id + "/comments", comment);
        verify(twitterService).addComment(id, comment);
    }
}