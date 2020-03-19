package academy.everyonecodes.creditcards;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IssuerTest {

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(true, new Issuer("American Express", Set.of("34", "37"), Set.of(15)), "378282246310005"),
                Arguments.of(false, new Issuer("Discover", Set.of("6011", "644", "645", "646", "647", "648", "649", "65"), Set.of(16, 19)), "30569309025904"),
                Arguments.of(false, new Issuer("MasterCard", Set.of("51", "52", "53", "54", "55"), Set.of(16)), "6011111111111117"),
                Arguments.of(true, new Issuer("Visa", Set.of("4"), Set.of(13, 16, 19)), "4111111111111111")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void issues(boolean expected, Issuer issuer, String input) {
        boolean result = issuer.issues(input);
        assertEquals(expected, result);
    }
}