package academy.everyonecodes.mocky;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MockyPostcardsEndpointIntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    String url = "/mocky/postcards";

    Postcard expectedPostcard1 = new Postcard("Silvia", "Anne",
            "My trip is awesome so far! I'm looking forward to tell you all about it!");

    Postcard expectedPostcard2 = new Postcard("Tom", "Ryan",
            "You have to visit this place, mate! It's great!");


    @Test
    void getOne() {
        Postcard result = restTemplate.getForObject(url + "/1", Postcard.class);

        assertEquals(expectedPostcard1, result);
    }

    @Test
    void getTwo() {
        Postcard[] response = restTemplate.getForObject(url + "/2", Postcard[].class);
        List<Postcard> result = List.of(response);

        List<Postcard> expected = List.of(expectedPostcard1, expectedPostcard2);
        assertEquals(expected, result);
    }
}

