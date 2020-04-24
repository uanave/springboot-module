package academy.everyonecodes.drhouseaccountancy.logic;

import academy.everyonecodes.drhouseaccountancy.domain.Invoice;
import academy.everyonecodes.drhouseaccountancy.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    public void markAsPaid(Long id) {
        Optional<Invoice> oInvoice = invoiceRepository.findById(id);
        if (oInvoice.isEmpty()) {
            return;
        }
        oInvoice.ifPresent(invoice -> {
            invoice.setPaid(true);
            invoiceRepository.save(invoice);
        });
    }
}
