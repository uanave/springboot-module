package academy.everyonecodes.home;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class HomeEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

//   test logic with properties result

    /*@Value("${message}")
    String message; */


    @Test
    void getMessage() {
        String url = "/home";
        String result = restTemplate.getForObject(url, String.class);
        /*String expected = "Kansas";
        Assertions.assertEquals(expected, result);*/
    }
}