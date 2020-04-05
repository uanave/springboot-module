package academy.everyonecodes.drhouseadmission;

import academy.everyonecodes.drhouseadmission.client.DiagnosesClient;
import academy.everyonecodes.drhouseadmission.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientEndpointIntegrationTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    DiagnosesClient diagnosesClient;

    String url = "/patients";

    @Test
    void post() {
        Patient patient = new Patient("test", "test");

        Patient result = testRestTemplate.postForObject(url, patient, Patient.class);

        assertNotNull(result);
        assertNotNull(result.getUuid());
        assertEquals(patient.getName(), result.getName());
        assertEquals(patient.getSymptoms(), result.getSymptoms());

        verify(diagnosesClient).send(result);
    }
}

