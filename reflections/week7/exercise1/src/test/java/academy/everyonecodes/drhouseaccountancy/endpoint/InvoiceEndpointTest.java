package academy.everyonecodes.drhouseaccountancy.endpoint;

import academy.everyonecodes.drhouseaccountancy.domain.Invoice;
import academy.everyonecodes.drhouseaccountancy.logic.InvoiceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class InvoiceEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    InvoiceService invoiceService;

    String url = "/invoices";

    @Test
    void get() {
        testRestTemplate.getForObject(url, Invoice[].class);

        verify(invoiceService).findAll();
    }

    @Test
    void put() {
        Long id = 123L;
        String paidUrl = this.url + "/" + id + "/paid";

        testRestTemplate.put(paidUrl, null);

        verify(invoiceService).markAsPaid(id);
    }
}
