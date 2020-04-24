package academy.everyonecodes.drhouseaccountancy.endpoint;

import academy.everyonecodes.drhouseaccountancy.domain.PatientDTO;
import academy.everyonecodes.drhouseaccountancy.logic.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    PatientService patientService;

    String url = "/patients";


    @Test
    void post() {
        PatientDTO patientDTO = new PatientDTO("uuid", "name", "symptoms", "diagnosis", "treatment");

        testRestTemplate.postForObject(url, patientDTO, PatientDTO.class);

        verify(patientService).post(patientDTO);
    }
}
