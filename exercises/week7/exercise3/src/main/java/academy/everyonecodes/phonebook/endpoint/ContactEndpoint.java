package academy.everyonecodes.phonebook.endpoint;

import academy.everyonecodes.phonebook.logic.ContactService;
import academy.everyonecodes.phonebook.persistence.domain.Contact;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactEndpoint {
    private final ContactService contactService;

    public ContactEndpoint(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    Contact save(@Valid @RequestBody Contact contact) {
        return contactService.post(contact);
    }

    @GetMapping
    List<Contact> findAll() {
        return contactService.findAll();
    }

    @GetMapping("/postalcodes/{postalCode}")
    List<Contact> finByPostalCode(@PathVariable String postalCode) {
        return contactService.findByPostalCode(postalCode);
    }
}
