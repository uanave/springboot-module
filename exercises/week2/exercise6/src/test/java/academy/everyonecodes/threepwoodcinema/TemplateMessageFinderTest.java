package academy.everyonecodes.threepwoodcinema;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TemplateMessageFinderTest {

    @Autowired
    TemplateMessageFinder finder;

    @ParameterizedTest
    @CsvSource({
            "'Good day --name--, don’t forget our 20% discount on tickets this Friday!', 'Mr. Black'",
            "'Dear --name--, you and your friends will have so much fun at the cinema this Friday with a 20% discount!', 'Ms. Black'",
            "'My dearest --name--, your lovely family gives you a 20% discount on tickets this Friday!', 'Threepwood'",
            "'My dearest --name--, your lovely family gives you a 20% discount on tickets this Friday!', 'Ms. Threepwood'",
            "'Hello --name--! How about a Friday night movie? This week with a 20% discount!', 'Gina'"
    })
    void find(String expected, String input) {
        String result = finder.find(input);
        assertEquals(expected, result);
    }
}