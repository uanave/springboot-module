package academy.everyonecodes.mocky;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MockyTextsEndpointIntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    String url = "/mocky/texts";

    @Test
    void getOne() {
        String response = restTemplate.getForObject(url + "/1", String.class);

        String expected = "Yay, it worked! This message comes from an external API in the cloud :)";
        assertEquals(expected, response);
    }

    @Test
    void getTwo() {
        String[] response = restTemplate.getForObject(url + "/2", String[].class);
        List<String> result = List.of(response);

        List<String> expected = List.of(
                "You are doing an amazing job!",
                "Keep on going, you're learning fast"
        );
        assertEquals(expected, result);
    }
}
