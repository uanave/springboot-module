package academy.everyonecodes.mysteriouscalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MysteriousAdditionTest {
    MysteriousAddition mysteriousAddition = new MysteriousAddition(1);

    @ParameterizedTest
    @CsvSource({
            "4, 3",
            "-3, -4",
            "1, 0"
    })
    void apply(int expected, int input) {
        int result = mysteriousAddition.apply(input);

        assertEquals(expected, result);
    }
}