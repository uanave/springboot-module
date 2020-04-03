package academy.everyomecodes.drhousediagnoses.endpoint;

import academy.everyomecodes.drhousediagnoses.domain.Patient;
import academy.everyomecodes.drhousediagnoses.logic.DiagnosisRoom;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    DiagnosisRoom diagnosisRoom;

    Patient patient = new Patient("3bc716e1-9c68-4c42-bc89-62b4e9c67f69", "Lisa", "fatigue, appear pale");


    @Test
    void post() {
        String url = "/patients";
        restTemplate.postForObject(url, patient, Patient.class);
        Mockito.verify(diagnosisRoom).diagnose(patient);
    }
}