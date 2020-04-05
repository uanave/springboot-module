package academy.everyonecodes.drhouseadmission.logic;

import academy.everyonecodes.drhouseadmission.client.DiagnosesClient;
import academy.everyonecodes.drhouseadmission.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class AdmissionTest {

    @Autowired
    Admission admission;

    @MockBean
    DiagnosesClient diagnosesClient;

    @MockBean
    UUIDProvider uuidProvider;


    @Test
    void admit() {
        Patient patient = new Patient("Lisa", "fatigue, appear pale");

        admission.admit(patient);

        verify(diagnosesClient).send(patient);
        
        verify(uuidProvider).provideUUID(patient);
    }
}