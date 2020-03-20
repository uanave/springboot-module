package academy.everyonecodes.secretagenthandshakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
class PriceToHandshakesTranslatorTest {

    @Autowired
    PriceToHandshakesTranslator priceToHandshakesTranslator;


    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of("thumb touches back", "little finger grab"), 23)

        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void translator(List<String> expected, int price) {
        List<String> result = priceToHandshakesTranslator.translate(price);
        Assertions.assertEquals(expected, result);
    }
}