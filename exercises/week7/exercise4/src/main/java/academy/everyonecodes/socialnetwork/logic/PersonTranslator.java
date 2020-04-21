package academy.everyonecodes.socialnetwork.logic;

import academy.everyonecodes.socialnetwork.domain.Person;
import academy.everyonecodes.socialnetwork.domain.PersonDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonTranslator {
    public Person convertToPerson(PersonDTO personDTO) {
        String name = personDTO.getName();
        List<String> friendNames = personDTO.getFriendNames();
        List<Person> friends = friendNames.stream()
                .map(Person::new)
                .collect(Collectors.toList());

        return new Person(name, friends);
    }

    public PersonDTO convertToPersonDTO(Person person) {
        Long id = person.getId();
        String name = person.getName();
        List<Person> friendNames = person.getFriends();
        List<String> friends = friendNames.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        return new PersonDTO(id, name, friends);
    }
}
