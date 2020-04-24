package academy.everyonecodes.drhouseaccountancy.endpoint;

import academy.everyonecodes.drhouseaccountancy.domain.Invoice;
import academy.everyonecodes.drhouseaccountancy.logic.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceEndpoint {
    private final InvoiceService invoiceService;

    public InvoiceEndpoint(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    List<Invoice> getAll() {
        return invoiceService.findAll();
    }

    @PutMapping("/{id}/paid")
    void put(@PathVariable Long id) {
        invoiceService.markAsPaid(id);
    }
}
