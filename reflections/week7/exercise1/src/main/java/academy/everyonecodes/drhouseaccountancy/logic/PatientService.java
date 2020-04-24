package academy.everyonecodes.drhouseaccountancy.logic;

import academy.everyonecodes.drhouseaccountancy.domain.Invoice;
import academy.everyonecodes.drhouseaccountancy.domain.Patient;
import academy.everyonecodes.drhouseaccountancy.domain.PatientDTO;
import academy.everyonecodes.drhouseaccountancy.repository.InvoiceRepository;
import academy.everyonecodes.drhouseaccountancy.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final Accountant accountant;
    private final InvoiceRepository invoiceRepository;
    private final PatientTranslator patientTranslator;


    public PatientService(PatientRepository patientRepository, Accountant accountant, InvoiceRepository invoiceRepository, PatientTranslator patientTranslator) {
        this.patientRepository = patientRepository;
        this.accountant = accountant;
        this.invoiceRepository = invoiceRepository;
        this.patientTranslator = patientTranslator;
    }

    public PatientDTO post(PatientDTO patientDTO) {
        Patient patient = patientTranslator.translateToPatient(patientDTO);
        Optional<Patient> oPatient = patientRepository.findByUuid(patient.getUuid());
        if (oPatient.isEmpty()) {
            patientRepository.save(patient);
        } else {
            patient = oPatient.get();
        }
        System.out.println(patient);
        Invoice invoice = accountant.generateInvoice(patient);
        invoiceRepository.save(invoice);
        return patientDTO;
    }
}
