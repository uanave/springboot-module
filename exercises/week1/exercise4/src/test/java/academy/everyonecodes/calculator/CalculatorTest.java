package academy.everyonecodes.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculatorTest {

    @Autowired
    Calculator calculator;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(Optional.of(3.0), "6.0 / 2.0"),
                Arguments.of(Optional.of(27.0), "9.0 * 3.0"),
                Arguments.of(Optional.empty(), "9.03.0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(Optional<Double> expected, String input) {
        Optional<Double> result = calculator.calculate(input);
        assertEquals(expected, result);
    }
}