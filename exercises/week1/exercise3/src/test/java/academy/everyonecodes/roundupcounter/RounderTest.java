package academy.everyonecodes.roundupcounter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RounderTest {

    @Autowired
    Rounder rounder;

    @ParameterizedTest
    @CsvSource({
            "3.0, 2.3",
            "1.0, 0.3",
            "0.0, 0.0",
            "-0.0, -0.7",
            "-6.0, -6.7"
    })
    void roundUp(double expected, double input) {
        double result = rounder.roundUp(input);
        assertEquals(expected, result);

    }

    @ParameterizedTest
    @CsvSource({
            "2.0, 2.3",
            "0.0, 0.3",
            "0.0, 0.0",
            "-1.0, -0.7",
            "-7.0, -6.7"
    })
    void roundDown(double expected, double input) {
        double result = rounder.roundDown(input);
        assertEquals(expected, result);
    }
}