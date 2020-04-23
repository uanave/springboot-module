package academy.everyonecodes.socialnetwork.endpoint;


import academy.everyonecodes.socialnetwork.domain.PersonDTO;
import academy.everyonecodes.socialnetwork.logic.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/persons")
public class PersonEndpoint {

    private final PersonService personService;

    public PersonEndpoint(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    PersonDTO post(@RequestBody PersonDTO personDTO) {
        return personService.save(personDTO);
    }

    @GetMapping
    Set<PersonDTO> get() {
        return personService.findAll();
    }

    @PutMapping("/{id1}/friend/{id2}")
    void put(@Valid  @PathVariable Long id1, @PathVariable Long id2) {
        personService.friend(id1, id2);
    }

    @PutMapping("/{id1}/unfriend/{id2}")
    void remove(@Valid @PathVariable Long id1, @PathVariable Long id2) {
        personService.unfriend(id1, id2);
    }
}
