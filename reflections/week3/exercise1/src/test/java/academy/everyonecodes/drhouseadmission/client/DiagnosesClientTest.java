package academy.everyonecodes.drhouseadmission.client;

import academy.everyonecodes.drhouseadmission.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DiagnosesClientTest {

    @Autowired
    DiagnosesClient diagnosesClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${diagnoses.url}")
    String url;


    @Test
    void send() {
        Patient patient = new Patient("Lisa", "fatigue, appear pale");

        diagnosesClient.send(patient);

        verify(restTemplate).postForObject(url + "/", patient, Patient.class);
    }
}