package academy.everyonecodes.phonebook.logic;

import academy.everyonecodes.phonebook.persistence.domain.Contact;
import academy.everyonecodes.phonebook.persistence.repository.AddressRepository;
import academy.everyonecodes.phonebook.persistence.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final AddressRepository addressRepository;
    private final ContactRepository contactRepository;

    public ContactService(AddressRepository addressRepository, ContactRepository contactRepository) {
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;
    }

    public Contact post(Contact contact) {
        addressRepository.save(contact.getAddress());
        return contactRepository.save(contact);
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public List<Contact> findByPostalCode(String postalCode) {
        return contactRepository.findByAddressPostalCode(postalCode);
    }
}
