package academy.everyonecodes.socialnetwork.logic;

import academy.everyonecodes.socialnetwork.domain.Person;
import academy.everyonecodes.socialnetwork.domain.PersonDTO;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonTranslator {
    public Person convertToPerson(PersonDTO personDTO) {
        String name = personDTO.getName();
        Set<String> friendNames = personDTO.getFriendNames();
        Set<Person> friends = friendNames.stream()
                .map(Person::new)
                .collect(Collectors.toSet());

        return new Person(name, friends);
    }

    public PersonDTO convertToPersonDTO(Person person) {
        Long id = person.getId();
        String name = person.getName();
        Set<Person> friendNames = person.getFriends();
        Set<String> friends = friendNames.stream()
                .map(Person::getName)
                .collect(Collectors.toSet());

        return new PersonDTO(id, name, friends);
    }
}
