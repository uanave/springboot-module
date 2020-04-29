package academy.everyonecodes.securedpolo.logic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PoloServiceTest {
    PoloService poloService = new PoloService();

    @ParameterizedTest
    @CsvSource({
            "What?, oh",
            "Polo, Marco",
            "What?, marco",
            "What?, ''",
            "What?, ' '"
    })
    void readText(String expected, String input) {
        String result = poloService.transformMessage(input);
        assertEquals(expected, result);
    }
}