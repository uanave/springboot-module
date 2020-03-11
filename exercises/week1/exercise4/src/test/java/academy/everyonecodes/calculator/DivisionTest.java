package academy.everyonecodes.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static java.lang.Float.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DivisionTest {

    @Autowired
    Division division;

    static Stream<Arguments> parameters() {
        Expression expression1 = new Expression("/", 6.0, 2.0);
        Expression expression2 = new Expression("/", 9.0, 3.0);
        Expression expression3 = new Expression("/", 0.0, 3.0);
        Expression expression4 = new Expression("/", 0.0, 0.0);
        return Stream.of(
                Arguments.of(3.0, expression1),
                Arguments.of(3.0, expression2),
                Arguments.of(0.0, expression3),
                Arguments.of(NaN, expression4)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(double expected, Expression input) {
        double result = division.calculate(input);

        assertEquals(expected, result);
    }
}