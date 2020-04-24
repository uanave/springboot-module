package academy.everyonecodes.drhouseaccountancy.logic;

import academy.everyonecodes.drhouseaccountancy.domain.Invoice;
import academy.everyonecodes.drhouseaccountancy.domain.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Accountant {
    private final double cost;

    public Accountant(@Value("${treatment.cost}") double cost) {
        this.cost = cost;
    }

    public Invoice generateInvoice(Patient patient) {
        return new Invoice(cost, false, patient);
    }
}
