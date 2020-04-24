package academy.everyonecodes.drhouseaccountancy.logic;

import academy.everyonecodes.drhouseaccountancy.domain.Invoice;
import academy.everyonecodes.drhouseaccountancy.domain.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class AccountantTest {

    @Autowired
    Accountant accountant;

    @Test
    void generateInvoice() {
        Patient patient = new Patient("123", "test", "test", "test", "test");
        accountant.generateInvoice(patient);
        Invoice result = accountant.generateInvoice(patient);
        Invoice expected = new Invoice(90, false, patient);
        Assertions.assertEquals(expected, result);
    }
}