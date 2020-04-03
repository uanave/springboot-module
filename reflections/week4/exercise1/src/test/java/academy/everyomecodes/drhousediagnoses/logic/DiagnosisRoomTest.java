package academy.everyomecodes.drhousediagnoses.logic;

import academy.everyomecodes.drhousediagnoses.domain.Patient;
import academy.everyomecodes.drhousediagnoses.logic.DiagnosisRoom;
import academy.everyomecodes.drhousediagnoses.logic.DrHouse;
import org.junit.jupiter.api.Assertions;
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

    Patient before = new Patient("3bc716e1-9c68-4c42-bc89-62b4e9c67f69", "Lisa", "fatigue, appear pale");
    Patient after = new Patient("3bc716e1-9c68-4c42-bc89-62b4e9c67f69", "Lisa", "fatigue, appear pale", "anemia");


    @Test
    void diagnose() {
        Mockito.when(drHouse.diagnose(before)).thenReturn(after);
        Patient result = drHouse.diagnose(before);
        Assertions.assertEquals(after, result);
        Mockito.verify(drHouse).diagnose(before);
    }
}