package academy.everyonecodes.advancedyml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DecimalNumberTest {

    @Autowired
    DecimalNumber decimalNumber;

    @Test
    void get() {
        double result = decimalNumber.getDecimalNumber();

        double expected = 1.618;
        Assertions.assertEquals(expected, result);
    }
}