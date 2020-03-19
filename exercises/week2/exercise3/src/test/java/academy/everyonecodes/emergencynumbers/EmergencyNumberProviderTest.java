package academy.everyonecodes.emergencynumbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EmergencyNumberProviderTest {

    @Autowired
    EmergencyNumberProvider provider;

    @ParameterizedTest
    @CsvSource({
            "133, Police",
            "112, BlaBla",
            "122, Fire brigade",
            "112, General emergency",
            "112, ''"
    })
    void provide(String expected, String input) {
        String result = provider.provide(input);

        assertEquals(expected, result);
    }
}