package academy.everyonecodes.polo;

import academy.everyonecodes.polo.domain.Polo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PoloTest {
    Polo polo = new Polo();

    @ParameterizedTest
    @CsvSource({
            "What?, oh",
            "Polo, Marco",
            "What?, marco",
            "What?, ''",
            "What?, ' '"
    })
    void readText(String expected, String input) {
        String result = polo.readText(input);
        assertEquals(expected, result);
    }
}