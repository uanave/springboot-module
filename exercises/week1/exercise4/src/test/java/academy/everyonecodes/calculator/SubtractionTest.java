package academy.everyonecodes.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SubtractionTest {

    @Autowired
    Subtraction subtraction;

    static Stream<Arguments> parameters() {
        Expression expression1 = new Expression("-", 6.0, 2.0);
        Expression expression2 = new Expression("-", 9.0, 3.0);
        return Stream.of(
                Arguments.of(4.0, expression1),
                Arguments.of(6.0, expression2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(double expected, Expression input) {
        double result = subtraction.calculate(input);

        assertEquals(expected, result);
    }
}