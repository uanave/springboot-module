package academy.everyonecodes.jsonplaceholder.communication.endpoint;

import academy.everyonecodes.jsonplaceholder.domain.Post;
import academy.everyonecodes.jsonplaceholder.communication.client.JsonPlaceholderClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PostEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    JsonPlaceholderClient jsonPlaceholderClient;

    String url = "/posts";

    Post post = new Post("title", "content", 1, 2);

    @Test
    void getAll() {
        restTemplate.getForObject(url, Post[].class);

        verify(jsonPlaceholderClient).getAll();
    }

    @Test
    void getOne() {
        restTemplate.getForObject(url + "/0", Post.class);

        verify(jsonPlaceholderClient).getOne(0);
    }

    @Test
    void post() {
        restTemplate.postForObject(url, post, Post.class);

        verify(jsonPlaceholderClient).post(post);
    }

    @Test
    void put() {
        restTemplate.put(url + "/0", post);

        verify(jsonPlaceholderClient).put(0, post);
    }

    @Test
    void deleteAll() {
        restTemplate.delete(url);

        verify(jsonPlaceholderClient).delete();
    }

    @Test
    void deleteOne() {
        restTemplate.delete(url + "/0");

        verify(jsonPlaceholderClient).delete(0);
    }
}
