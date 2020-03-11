package academy.everyonecodes.roundupcounter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UpCounterTest {

    @Autowired
    UpCounter counter;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, List.of(2.7, 2.3, 2.1, 0.3)),
                Arguments.of(0, List.of(0.3, 2.3, 7.1, 0.3)),
                Arguments.of(4, List.of(0.7, 2.7, 7.9, 0.6))
        );
    }


    @ParameterizedTest
    @MethodSource("parameters")
    void count(long expected, List<Double> numbers) {
        long result = counter.count(numbers);
        assertEquals(expected, result);
    }
}