package academy.everyonecodes.creditcards;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CreditCardsTest {

    @Autowired
    CreditCards creditCards;

    @ParameterizedTest
    @CsvSource({
            "'American Express', '378282246310005'",
            "'MasterCard', '5105105105105100'",
            "'Visa', '4111111111111111'",
            "'Discover', '6011111111111117'",
            "'Invalid', '011111111111117'",
            "'Not Supported', '3530111333300000'"
    })
    void inspect(String expected, String input) {
        String result = creditCards.inspect(input);

        assertEquals(expected, result);
    }
}