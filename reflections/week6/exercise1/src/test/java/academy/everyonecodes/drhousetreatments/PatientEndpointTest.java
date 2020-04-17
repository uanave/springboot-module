package academy.everyonecodes.drhousetreatments;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    TreatmentService treatmentService;

    String url = "/patients";

    @Test
    void post() {
        Patient patient = new Patient();

        testRestTemplate.postForObject(url, patient, Patient.class);
        verify(treatmentService).save(patient);
    }
}