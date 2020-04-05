package academy.everyomecodes.drhousediagnoses.logic;

import academy.everyomecodes.drhousediagnoses.domain.Patient;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DrHouseTest {

    @Autowired
    DrHouse drHouse;


    @ParameterizedTest
    @CsvSource({
            "lupus, ''",
            "lupus, test-symptom2",
            "test-diagnosis, test-symptom",
            "test-diagnosis, Test-symptom",

    })
    void diagnose(String diagnosis, String symptoms) {
        Patient incomingPatient = new Patient("test", "test", symptoms);
        assertNull(incomingPatient.getDiagnosis());

        drHouse.diagnose(incomingPatient);

        Patient diagnosedPatient = new Patient("test", "test", symptoms, diagnosis);
        assertNotNull(incomingPatient.getDiagnosis());
        assertEquals(diagnosedPatient, incomingPatient);
    }
}