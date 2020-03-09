package academy.everyonecodes.roundupcounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UpCounterTest {

    @Autowired
    UpCounter counter;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, List.of(2.7, 2.3, 2.1, 0.3))
        );
    }


    @ParameterizedTest
    @MethodSource("parameters")
    void count(long expected, List<Double> numbers) {
        long result = counter.count(numbers);
        assertEquals(expected, result);
    }
}