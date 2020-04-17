package academy.everyonecodes.drhousetreatments;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TreatmentEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    TreatmentService treatmentService;

    String url = "/treatments";

    @Test
    void findAll() {
        testRestTemplate.getForObject(url, Treatment[].class);

        verify(treatmentService).findAll();
    }

    @Test
    void getByUuid() {
        String uuid = "test";

        testRestTemplate.getForObject(url + "/" + uuid, Treatment[].class);

        verify(treatmentService).findAllByUUID(uuid);
    }
}