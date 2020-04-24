package academy.everyonecodes.drhouseaccountancy.logic;

import academy.everyonecodes.drhouseaccountancy.domain.Invoice;
import academy.everyonecodes.drhouseaccountancy.domain.Patient;
import academy.everyonecodes.drhouseaccountancy.repository.InvoiceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class InvoiceServiceTest {

    @Autowired
    InvoiceService invoiceService;

    @MockBean
    InvoiceRepository invoiceRepository;

    @Test
    void findAll() {
        invoiceService.findAll();
        verify(invoiceRepository).findAll();

    }

    @Test
    void markAsPaidDoesNotFindInvoice() {
        Long id = 123L;
        when(invoiceRepository.findById(id))
                .thenReturn(Optional.empty());

        invoiceService.markAsPaid(id);

        verify(invoiceRepository).findById(id);
        verifyNoMoreInteractions(invoiceRepository);
    }

    @Test
    void markAsPaidFindsInvoice() {
        Long id = 123L;
        Invoice invoice = new Invoice(0, false, new Patient());
        when(invoiceRepository.findById(id))
                .thenReturn(Optional.of(invoice));
        assertFalse(invoice.isPaid());

        invoiceService.markAsPaid(id);

        verify(invoiceRepository).findById(id);
        Invoice expected = new Invoice(0, true, new Patient());
        verify(invoiceRepository).save(expected);
    }

}