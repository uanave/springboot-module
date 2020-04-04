package academy.everyomecodes.drhousediagnoses.logic;

import academy.everyomecodes.drhousediagnoses.domain.Patient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DiagnosisRoomTest {

    @Autowired
    DiagnosisRoom diagnosisRoom;

    @MockBean
    DrHouse drHouse;

    @Test
    void diagnose() {
        Patient patient = new Patient("3bc716e1-9c68-4c42-bc89-62b4e9c67f69", "Lisa", "fatigue, appear pale");
        drHouse.diagnose(patient);
        Mockito.verify(drHouse).diagnose(patient);
    }
}