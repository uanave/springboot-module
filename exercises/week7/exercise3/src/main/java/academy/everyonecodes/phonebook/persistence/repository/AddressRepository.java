package academy.everyonecodes.phonebook.persistence.repository;

import academy.everyonecodes.phonebook.persistence.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
