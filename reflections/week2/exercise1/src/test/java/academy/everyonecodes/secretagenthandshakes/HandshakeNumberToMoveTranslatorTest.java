package academy.everyonecodes.secretagenthandshakes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HandshakeNumberToMoveTranslatorTest {

    @Autowired
    HandshakeNumberToMoveTranslator handshakeNumberToMoveTranslator;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(Optional.empty(), 17),
                Arguments.of(Optional.of("thumb touches back"), 2)

        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void translate(Optional<String> expected, int digit) {
        Optional<String> result = handshakeNumberToMoveTranslator.translate(digit);
        assertEquals(expected.hashCode(), result.hashCode());
    }
}