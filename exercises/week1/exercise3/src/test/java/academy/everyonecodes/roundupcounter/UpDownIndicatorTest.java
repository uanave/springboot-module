package academy.everyonecodes.roundupcounter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UpDownIndicatorTest {

    @Autowired
    UpDownIndicator indicator;

    @ParameterizedTest
    @CsvSource({
            "UP, 2.7",
            "DOWN, 2.3",
            "SAME, 0.5",
    })
    void indicate(String expected, double input) {
        String result = indicator.indicate(input);
        assertEquals(expected, result);
    }
}