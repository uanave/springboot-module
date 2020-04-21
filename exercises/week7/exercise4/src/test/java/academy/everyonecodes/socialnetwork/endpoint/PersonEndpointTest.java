package academy.everyonecodes.socialnetwork.endpoint;

import academy.everyonecodes.socialnetwork.domain.PersonDTO;
import academy.everyonecodes.socialnetwork.logic.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PersonEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    PersonService personService;

    String url = "/persons";
    PersonDTO personDTO = new PersonDTO("Tom");
    Long id1 = 1L;
    Long id2 = 2L;

    @Test
    void post() {
        testRestTemplate.postForObject(url, personDTO, PersonDTO.class);

        verify(personService).save(personDTO);
    }

    @Test
    void get() {
        testRestTemplate.getForObject(url, PersonDTO[].class);

        verify(personService).findAll();
    }

    @Test
    void put() {
        testRestTemplate.put(url + "/" + id1 + "/friend/" + id2, id1, id2);

        verify(personService).friend(id1, id2);
    }

    @Test
    void remove() {
        testRestTemplate.put(url + "/" + id1 + "/unfriend/" + id2, id1, id2);

        verify(personService).unfriend(id1, id2);
    }
}