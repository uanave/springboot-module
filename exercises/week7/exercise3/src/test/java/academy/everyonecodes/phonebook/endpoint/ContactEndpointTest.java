package academy.everyonecodes.phonebook.endpoint;

import academy.everyonecodes.phonebook.logic.ContactService;
import academy.everyonecodes.phonebook.persistence.domain.Address;
import academy.everyonecodes.phonebook.persistence.domain.Contact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ContactEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    ContactService contactService;

    String url = "/contacts";

    Contact contact = new Contact("Ion", new Address("Fakestreet", "6500"));


    @Test
    void save() {

        testRestTemplate.postForObject(url, contact, Contact.class);

        verify(contactService).post(contact);

    }

    @Test
    void findAll() {
        testRestTemplate.getForObject(url, Contact[].class);

        verify(contactService).findAll();
    }

    @Test
    void finByPostalCode() {
        String postalCode = "1234";
        String postalCodeUrl = url + "/postalcodes/" + postalCode;

        testRestTemplate.getForObject(postalCodeUrl, Contact[].class);

        verify(contactService).findByPostalCode(postalCode);
    }
}