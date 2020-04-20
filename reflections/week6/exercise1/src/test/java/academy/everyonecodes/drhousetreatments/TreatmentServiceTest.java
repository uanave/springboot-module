package academy.everyonecodes.drhousetreatments;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TreatmentServiceTest {

    @Autowired
    TreatmentService treatmentService;

    @MockBean
    TreatmentRepository treatmentRepository;

    Patient patient = new Patient("uuid", "name", "symptoms", "diagnosis", "treatment");

    @Test
    void save() {
        treatmentService.save(patient);

        Treatment treatment =
                new Treatment("uuid", "name", "symptoms", "diagnosis", "treatment");

        verify(treatmentRepository).save(treatment);
    }

    @Test
    void findAll() {
        treatmentService.findAll();

        verify(treatmentRepository).findAll();
    }

    @Test
    void findAllByUUID() {
        String uuid = "test";

        treatmentService.findAllByUUID(uuid);

        verify(treatmentRepository).findAllByUuid(uuid);
    }
}