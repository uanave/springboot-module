package academy.everyomecodes.drhousediagnoses.logic;

import academy.everyomecodes.drhousediagnoses.client.TreatmentsClient;
import academy.everyomecodes.drhousediagnoses.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DiagnosisRoomTest {

    @Autowired
    DiagnosisRoom diagnosisRoom;

    @MockBean
    DrHouse drHouse;

    @MockBean
    TreatmentsClient treatmentsClient;

    @Test
    void diagnose() {
        Patient patient = new Patient("3bc716e1-9c68-4c42-bc89-62b4e9c67f69", "Lisa", "fatigue, appear pale");

        diagnosisRoom.diagnose(patient);

        verify(drHouse).diagnose(patient);

        verify(treatmentsClient).send(patient);
    }
}