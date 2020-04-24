package academy.everyonecodes.drhouseaccountancy.repository;

import academy.everyonecodes.drhouseaccountancy.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
