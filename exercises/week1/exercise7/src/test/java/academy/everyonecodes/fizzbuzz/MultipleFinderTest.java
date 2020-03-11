package academy.everyonecodes.fizzbuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultipleFinderTest {
    private MultipleFinder multipleThree = new MultipleFinder(3);
    private MultipleFinder multipleFive = new MultipleFinder(5);


    @ParameterizedTest
    @CsvSource({
            "true, 9",
            "false, 7"
    })
    void isMultiple3(boolean expected, int input) {
        boolean result = multipleThree.isMultiple(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "true, 25",
            "false, 16"
    })
    void isMultiple5(boolean expected, int input) {
        boolean result = multipleFive.isMultiple(input);
        assertEquals(expected, result);

    }
}