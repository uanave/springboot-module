package academy.everyonecodes.socialnetwork.logic;

import academy.everyonecodes.socialnetwork.domain.Person;
import academy.everyonecodes.socialnetwork.domain.PersonDTO;
import academy.everyonecodes.socialnetwork.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonTranslator personTranslator;

    public PersonService(PersonRepository personRepository, PersonTranslator personTranslator) {
        this.personRepository = personRepository;
        this.personTranslator = personTranslator;
    }

    public void friend(Long id1, Long id2) {
        Optional<Person> oPerson1 = personRepository.findById(id1);
        Optional<Person> oPerson2 = personRepository.findById(id2);
        if (oPerson1.isPresent() && oPerson2.isPresent() && (!id1.equals(id2))) {
            Set<Person> friends1 = oPerson1.get().getFriends();
            oPerson2.ifPresent(friends1::add);
            Set<Person> friends2 = oPerson2.get().getFriends();
            oPerson1.ifPresent(friends2::add);
        }
        oPerson1.ifPresent(personRepository::save);
        oPerson2.ifPresent(personRepository::save);

    }

    public PersonDTO save(PersonDTO personDTO) {
        Person person = personTranslator.convertToPerson(personDTO);
        personRepository.save(person);
        return personTranslator.convertToPersonDTO(person);
    }

    public Set<PersonDTO> findAll() {
        return personRepository.findAll().stream()
                .map(personTranslator::convertToPersonDTO)
                .collect(Collectors.toSet());
    }

    public void unfriend(Long id1, Long id2) {
        Optional<Person> oPerson1 = personRepository.findById(id1);
        Optional<Person> oPerson2 = personRepository.findById(id2);
        if (oPerson1.isPresent() && oPerson2.isPresent() && (!id1.equals(id2))) {
            Set<Person> friends1 = oPerson1.get().getFriends();
            oPerson2.ifPresent(friends1::remove);
            Set<Person> friends2 = oPerson2.get().getFriends();
            oPerson1.ifPresent(friends2::remove);
        }
        oPerson1.ifPresent(personRepository::save);
        oPerson2.ifPresent(personRepository::save);
    }

}
