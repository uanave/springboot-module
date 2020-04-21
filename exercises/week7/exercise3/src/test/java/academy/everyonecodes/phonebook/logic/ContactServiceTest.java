package academy.everyonecodes.phonebook.logic;

import academy.everyonecodes.phonebook.persistence.domain.Address;
import academy.everyonecodes.phonebook.persistence.domain.Contact;
import academy.everyonecodes.phonebook.persistence.repository.AddressRepository;
import academy.everyonecodes.phonebook.persistence.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ContactServiceTest {

    @Autowired
    ContactService contactService;

    @MockBean
    ContactRepository contactRepository;

    @MockBean
    AddressRepository addressRepository;

    @Test
    void post() {
        Contact contact = new Contact("Ion", new Address("Fakestreet", "6500"));

        contactService.post(contact);

        verify(addressRepository).save(contact.getAddress());
        verify(contactRepository).save(contact);
    }

    @Test
    void findAll() {
        contactService.findAll();

        verify(contactRepository).findAll();
    }

    @Test
    void findByPostalCode() {
        String postalCode = "6500";

        contactService.findByPostalCode(postalCode);

        verify(contactRepository).findByAddressPostalCode(postalCode);
    }
}