package academy.everyonecodes.socialnetwork.logic;

import academy.everyonecodes.socialnetwork.domain.Person;
import academy.everyonecodes.socialnetwork.domain.PersonDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTranslatorTest {
    PersonTranslator personTranslator = new PersonTranslator();

    @Test
    void convertToPerson() {
        PersonDTO personDTO = new PersonDTO("Tim");
        Person result = personTranslator.convertToPerson(personDTO);
        Person expected = new Person("Tim", List.of());
        Assertions.assertEquals(expected, result);
    }

    @Test
    void convertToPersonDTO() {
        Person person = new Person("Tim");
        PersonDTO result = personTranslator.convertToPersonDTO(person);
        PersonDTO expected = new PersonDTO("Tim");
        Assertions.assertEquals(expected, result);

    }
}