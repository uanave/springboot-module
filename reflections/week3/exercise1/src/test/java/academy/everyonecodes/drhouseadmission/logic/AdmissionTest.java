package academy.everyonecodes.drhouseadmission.logic;

import academy.everyonecodes.drhouseadmission.client.DiagnosesClient;
import academy.everyonecodes.drhouseadmission.domain.Patient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class AdmissionTest {

    @Autowired
    Admission admission;

    @MockBean
    DiagnosesClient diagnosesClient;

    Patient patient = new Patient("Lisa", "fatigue, appear pale");

    @Test
    void admit() {
        Patient result = admission.admit(patient);
        System.out.println(result);
        Mockito.verify(diagnosesClient).send(patient);
    }
}