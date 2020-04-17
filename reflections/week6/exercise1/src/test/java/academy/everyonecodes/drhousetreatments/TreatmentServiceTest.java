package academy.everyonecodes.drhousetreatments;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TreatmentServiceTest {

    @Autowired
    TreatmentService treatmentService;

    @MockBean
    TreatmentRepository treatmentRepository;

    @MockBean
    Nurse nurse;

    Patient patient = new Patient();

    @Test
    void save() {
        nurse.provideTreatment(patient);

        treatmentService.save(patient);

        verify(nurse).provideTreatment(patient);
        verify(treatmentRepository).save(any(Treatment.class));

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