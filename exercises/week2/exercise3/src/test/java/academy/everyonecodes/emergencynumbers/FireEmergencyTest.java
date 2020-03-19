package academy.everyonecodes.emergencynumbers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FireEmergencyTest {

    @Autowired
    FireEmergency fire;

    @Test
    void getName() {
        String result = fire.getName();

        String expected = "Fire brigade";
        assertEquals(expected, result);

    }

    @Test
    void getNumber() {
        String result = fire.getNumber();

        String expected = "122";
        assertEquals(expected, result);
    }
}