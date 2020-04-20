package academy.everyomecodes.drhousediagnoses.client;

import academy.everyomecodes.drhousediagnoses.domain.Patient;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TreatmentsClientTest {

    @Autowired
    TreatmentsClient treatmentsClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${treatments.url}")
    String url;

    @Test
    void send() throws JsonProcessingException {
        Patient patient = new Patient("uuid", "name", "symptoms", "diagnosis");

        treatmentsClient.send(patient);

        verify(restTemplate).postForObject(url, patient, Void.class);
    }
}