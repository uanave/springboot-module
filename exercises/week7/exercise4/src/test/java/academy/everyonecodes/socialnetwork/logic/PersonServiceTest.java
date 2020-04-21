package academy.everyonecodes.socialnetwork.logic;

import academy.everyonecodes.socialnetwork.domain.Person;
import academy.everyonecodes.socialnetwork.domain.PersonDTO;
import academy.everyonecodes.socialnetwork.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class PersonServiceTest {

    @Autowired
    PersonService personService;

    @MockBean
    PersonRepository personRepository;

    @MockBean
    PersonTranslator personTranslator;

    PersonDTO personDTO = new PersonDTO("Tom");
    Person person = new Person("Tom");
    Long id1 = 1L;
    Long id2 = 2L;


    @Test
    void save() {
        when(personTranslator.convertToPerson(personDTO)).thenReturn(person);
        personService.save(personDTO);

        verify(personRepository).save(person);
        verify(personTranslator).convertToPerson(personDTO);

    }

    @Test
    void findAll() {
        personService.findAll();

        verify(personRepository).findAll();
    }

    @Test
    void friend() {
        personService.friend(id1, id2);

        verify(personRepository).findById(id1);

        verify(personRepository).findById(id2);

    }

    @Test
    void unfriend() {
        personService.unfriend(id1, id2);

        verify(personRepository).findById(id1);

        verify(personRepository).findById(id2);
    }
}