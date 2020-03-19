package academy.everyonecodes.threepwoodcinema;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TemplateEngineTest {

    @Autowired
    TemplateEngine templateEngine;

    @ParameterizedTest
    @CsvSource({
            "'Good day Mr. Choko, don’t forget our 20% discount on tickets this Friday!', 'Mr. Choko'",
            "'Dear Ms. Black, you and your friends will have so much fun at the cinema this Friday with a 20% discount!', 'Ms. Black'",
            "'My dearest Marie Threepwood, your lovely family gives you a 20% discount on tickets this Friday!', 'Marie Threepwood'",
            "'My dearest Ms. Threepwood, your lovely family gives you a 20% discount on tickets this Friday!', 'Ms. Threepwood'",
            "'Hello Gina! How about a Friday night movie? This week with a 20% discount!', 'Gina'"
    })
    void find(String expected, String input) {
        String result = templateEngine.customiseMessage(input);
        assertEquals(expected, result);
    }
}