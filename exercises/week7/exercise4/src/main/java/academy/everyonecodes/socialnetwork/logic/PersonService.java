package academy.everyonecodes.socialnetwork.logic;

import academy.everyonecodes.socialnetwork.domain.Person;
import academy.everyonecodes.socialnetwork.domain.PersonDTO;
import academy.everyonecodes.socialnetwork.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonTranslator personTranslator;

    public PersonService(PersonRepository personRepository, PersonTranslator personTranslator) {
        this.personRepository = personRepository;
        this.personTranslator = personTranslator;
    }

    public PersonDTO save(PersonDTO personDTO) {
        Person person = personTranslator.convertToPerson(personDTO);
        personRepository.save(person);
        return personTranslator.convertToPersonDTO(person);

    }

    public List<PersonDTO> findAll() {
        return personRepository.findAll().stream()
                .map(personTranslator::convertToPersonDTO)
                .collect(Collectors.toList());
    }

    public void friend(Long id1, Long id2) {
        Optional<Person> oPerson1 = personRepository.findById(id1);
        Optional<Person> oPerson2 = personRepository.findById(id2);
        if (oPerson1.isPresent() && oPerson2.isPresent()) {
            List<Person> friends = oPerson1.get().getFriends();
            oPerson2.ifPresent(friends::add);
            List<Person> friends2 = oPerson2.get().getFriends();
            oPerson1.ifPresent(friends2::add);
        }
        oPerson1.ifPresent(personRepository::save);
        oPerson2.ifPresent(personRepository::save);

    }

    public void unfriend(Long id1, Long id2) {
        Optional<Person> oPerson1 = personRepository.findById(id1);
        Optional<Person> oPerson2 = personRepository.findById(id2);
        if (oPerson1.isPresent() && oPerson2.isPresent()) {
            List<Person> friends = oPerson1.get().getFriends();
            oPerson2.ifPresent(friends::remove);
            List<Person> friends2 = oPerson2.get().getFriends();
            oPerson1.ifPresent(friends2::remove);
        }
        oPerson1.ifPresent(personRepository::save);
        oPerson2.ifPresent(personRepository::save);

    }

}
