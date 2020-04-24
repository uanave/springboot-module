package academy.everyonecodes.drhouseaccountancy.logic;

import academy.everyonecodes.drhouseaccountancy.domain.Invoice;
import academy.everyonecodes.drhouseaccountancy.domain.Patient;
import academy.everyonecodes.drhouseaccountancy.domain.PatientDTO;
import academy.everyonecodes.drhouseaccountancy.repository.InvoiceRepository;
import academy.everyonecodes.drhouseaccountancy.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class PatientServiceTest {

    @Autowired
    PatientService patientService;

    @MockBean
    PatientRepository patientRepository;

    @MockBean
    Accountant accountant;

    @MockBean
    InvoiceRepository invoiceRepository;

    @MockBean
    PatientTranslator patientTranslator;

    PatientDTO patientDTO = new PatientDTO("uuid", "name", "symptoms", "diagnosis", "treatment");
    Patient patient = new Patient("uuid", "name", "symptoms", "diagnosis", "treatment");
    String uuid = "uuid";
    Invoice invoice = new Invoice(90, true, patient);

    @Test
    void postWithoutSaving() {

        when(patientTranslator.translateToPatient(patientDTO)).thenReturn(patient);
        when(patientRepository.findOneByUuid(uuid)).thenReturn(Optional.of(patient));
        verifyNoMoreInteractions(patientRepository);

        when(accountant.generateInvoice(patient)).thenReturn(invoice);

        patientService.post(patientDTO);

        verify(patientTranslator).translateToPatient(patientDTO);
        verify(accountant).generateInvoice(patient);
        verify(invoiceRepository).save(invoice);
    }

    @Test
    void postAndSave() {

        when(patientTranslator.translateToPatient(patientDTO)).thenReturn(patient);
        when(patientRepository.findOneByUuid(uuid)).thenReturn(Optional.empty());
        when(patientRepository.save(patient)).thenReturn(patient);
        when(accountant.generateInvoice(patient)).thenReturn(invoice);

        patientService.post(patientDTO);

        verify(patientTranslator).translateToPatient(patientDTO);
        verify(accountant).generateInvoice(patient);
        verify(invoiceRepository).save(invoice);
    }
}