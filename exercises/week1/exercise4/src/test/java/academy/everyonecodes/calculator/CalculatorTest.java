package academy.everyonecodes.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CalculatorTest {

    @Autowired
    Calculator calculator;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(3.0, "6.0 / 2.0"),
                Arguments.of(27.0, "9.0 * 3.0"),
                Arguments.of(5.0, "15.0 - 10.0"),
                Arguments.of(25.0, "15.0 + 10.0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(double expected, String input) {
        double result = calculator.calculate(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "9.04.5",
            "9.0 & 5.0",
            "9.0 $ 5.0"
    })
    void calculateNonValid(String input) {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(input));
    }
}