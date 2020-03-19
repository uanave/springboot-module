package academy.everyonecodes.emergencynumbers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PoliceEmergencyTest {

    @Autowired
    PoliceEmergency policeEmergency;

    @Test
    void getName() {
        String result = policeEmergency.getName();

        String expected = "Police";
        assertEquals(expected, result);
    }

    @Test
    void getNumber() {
        String result = policeEmergency.getNumber();

        String expected = "133";
        assertEquals(expected, result);
    }
}