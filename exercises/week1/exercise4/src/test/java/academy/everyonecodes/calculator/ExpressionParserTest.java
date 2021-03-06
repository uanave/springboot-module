package academy.everyonecodes.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.Stream;

import static java.lang.Float.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ExpressionParserTest {

    @Autowired
    ExpressionParser parser;

    static Stream<Arguments> parameters() {
        Expression expression1 = new Expression("+", 1.0, 2.0);
        Expression expression2 = new Expression("/", 6.0, 2.0);
        Expression expression3 = new Expression("/", 0.0, 2.0);
        return Stream.of(
                Arguments.of(Optional.of(expression1), "1.0 + 2.0"),
                Arguments.of(Optional.of(expression3), "0.0 / 2.0"),
                Arguments.of(Optional.empty(), "1.0 2.0"),
                Arguments.of(Optional.empty(), "aaaaa"),
                Arguments.of(Optional.empty(), "a a a"),
                Arguments.of(Optional.of(expression2), "6.0 / 2.0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void parse(Optional<Expression> expected, String input) {
        Optional<Expression> result = parser.parse(input);
        assertEquals(expected.hashCode(), result.hashCode());
    }
}