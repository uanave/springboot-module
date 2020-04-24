package academy.everyonecodes.socialnetwork.logic;

import academy.everyonecodes.socialnetwork.domain.Person;
import academy.everyonecodes.socialnetwork.domain.PersonDTO;
import academy.everyonecodes.socialnetwork.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class PersonServiceTest {

    @Autowired
    PersonService personService;

    @MockBean
    PersonRepository personRepository;

    @MockBean
    PersonTranslator personTranslator;

    static Stream<Arguments> parameters() {
        return Stream.of(
                of(Optional.empty(), Optional.empty()),
                of(Optional.empty(), Optional.of(new Person("name"))),
                of(Optional.of(new Person("name")), Optional.empty())
        );
    }

    @Test
    void findAll() {
        Person person1 = new Person("name1");
        Person person2 = new Person("name2");
        when(personRepository.findAll())
                .thenReturn(List.of(person1, person2));

        personService.findAll();

        verify(personRepository).findAll();
        verify(personTranslator).convertToPersonDTO(person1);
        verify(personTranslator).convertToPersonDTO(person2);
    }

    @Test
    void save() {
        PersonDTO personDTO = new PersonDTO("name");
        Person person = new Person("name");
        when(personTranslator.convertToPerson(personDTO))
                .thenReturn(person);

        personService.save(personDTO);

        verify(personTranslator).convertToPerson(personDTO);
        verify(personRepository).save(person);
        verify(personTranslator).convertToPersonDTO(person);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void friendDoesNotFindBothPersons(Optional<Person> oPerson1, Optional<Person> oPerson2) {
        Long id1 = 123L;
        Long id2 = 321L;
        when(personRepository.findById(id1))
                .thenReturn(oPerson1);
        when(personRepository.findById(id2))
                .thenReturn(oPerson2);

        personService.friend(id1, id2);

        verify(personRepository).findById(id1);
        verify(personRepository).findById(id2);
        verifyNoMoreInteractions(personRepository);
    }

    @Test
    void friendFindsBothPersons() {
        Long id1 = 123L;
        Long id2 = 321L;
        Person person1 = new Person("name1");
        Person person2 = new Person("name2");
        when(personRepository.findById(id1))
                .thenReturn(Optional.of(person1));
        when(personRepository.findById(id2))
                .thenReturn(Optional.of(person2));

        personService.friend(id1, id2);

        verify(personRepository).findById(id1);
        verify(personRepository).findById(id2);
        verify(personRepository).save(new Person("name1", Set.of(person2)));
        verify(personRepository).save(new Person("name2", Set.of(person1)));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void unfriendDoesNotFindBothPersons(Optional<Person> oPerson1, Optional<Person> oPerson2) {
        Long id1 = 123L;
        Long id2 = 321L;
        when(personRepository.findById(id1))
                .thenReturn(oPerson1);
        when(personRepository.findById(id2))
                .thenReturn(oPerson2);

        personService.unfriend(id1, id2);

        verify(personRepository).findById(id1);
        verify(personRepository).findById(id2);
        verifyNoMoreInteractions(personRepository);
    }

    @Test
    void unfriendFindsBothPersons() {
        Long id1 = 123L;
        Long id2 = 321L;
        Person person1 = new Person(id1, "name1", new HashSet<>(Set.of(new Person(id2, "name2"))));
        Person person2 = new Person(id2, "name2", new HashSet<>(Set.of(new Person(id1, "name1"))));
        when(personRepository.findById(id1))
                .thenReturn(Optional.of(person1));
        when(personRepository.findById(id2))
                .thenReturn(Optional.of(person2));

        personService.unfriend(id1, id2);

        verify(personRepository).findById(id1);
        verify(personRepository).findById(id2);
        verify(personRepository).save(new Person(id1, "name1", Set.of()));
        verify(personRepository).save(new Person(id2, "name2", Set.of()));
    }
}
