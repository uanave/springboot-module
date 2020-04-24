package academy.everyonecodes.drhousetreatments;

import academy.everyonecodes.drhousetreatments.client.AccountancyClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class NurseTest {

    @Autowired
    Nurse nurse;

    @MockBean
    TreatmentService treatmentService;

    @MockBean
    AccountancyClient accountancyClient;

    @Test
    void provideTreatment() {
        Patient patient = new Patient("uuid", "name", "symptoms", "diagnosis");
        String expected = "spend one day in the hospital bed";
        assertNull(patient.getTreatment());

        nurse.provideTreatment(patient);

        assertNotNull(patient.getTreatment());
        assertEquals(expected, patient.getTreatment());
        verify(treatmentService).save(patient);
        verify(accountancyClient).send(patient);
    }
}