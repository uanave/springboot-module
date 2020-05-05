package academy.everyonecodes.validation.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class TextReceiverTest {
    @Autowired
    TextReceiver textReceiver;

    @ParameterizedTest
    @CsvSource({
            "da",
            "a",
            "''"
    })
    public void whenTextIsInvalid(String text) {
        assertThrows(ConstraintViolationException.class, () -> {
            textReceiver.receive(text);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "summer, summer",
            "cat, cat",
            "jsofjowiafjweafhwai, jsofjowiafjweafhwai"
    })
    public void whenTextIsValid(String expected, String input) {
        String result = textReceiver.receive(input);
        Assertions.assertEquals(expected, result);
    }
}