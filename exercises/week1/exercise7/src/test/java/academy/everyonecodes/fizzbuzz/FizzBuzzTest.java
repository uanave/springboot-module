package academy.everyonecodes.fizzbuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FizzBuzzTest {
    @Autowired
    FizzBuzz fizzBuzz;

    @ParameterizedTest
    @CsvSource({
            "Fizz, 9",
            "FizzBuzz, 15",
            "Buzz, 5",
            "'17', 17"
    })
    void apply(String expected, int input) {
        String result = fizzBuzz.apply(input);
        assertEquals(expected, result);
    }
}