package academy.everyonecodes.advancedyml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SeveralValuesTest {
    @Autowired
    SeveralValues severalValues;

    @Test
    void getNumbers() {
        List<Integer> result = severalValues.getNaturalNumbers();

        List<Integer> expected = List.of(3, 6, 9);
        assertEquals(expected, result);
    }

    @Test
    void getDecimalNumbers() {
        List<Double> result = severalValues.getDecimalNumbers();

        List<Double> expected = List.of(3.14, 2.71, 3.359);
        assertEquals(expected, result);
    }

    @Test
    void getWords() {
        List<String> result = severalValues.getWords();

        List<String> expected = List.of("Answer", "to", "the", "Ultimate", "Question", "of", "Life", "the", "Universe", "and", "Everything");
        assertEquals(expected, result);
    }

    @Test
    void getChoices() {
        List<Boolean> result = severalValues.getChoices();

        List<Boolean> expected = List.of(true, false, false, true);
        assertEquals(expected, result);
    }
}