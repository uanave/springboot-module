package academy.everyonecodes.languagebarriers.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class VisitorCounterTest {

    VisitorCounter visitorCounter = new VisitorCounter(1);

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(2, new VisitorCounter(1)),
                Arguments.of(6, new VisitorCounter(5)),
                Arguments.of(1, new VisitorCounter(0))
        );
    }

    static Stream<Arguments> increment() {
        return Stream.of(
                Arguments.of(110, new VisitorCounter(10), 100),
                Arguments.of(1050, new VisitorCounter(50), 1000),
                Arguments.of(25, new VisitorCounter(0), 25)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void increment(int expected, VisitorCounter visitorCounter) {
        visitorCounter.increment();
        int result = visitorCounter.getCount();
        Assertions.assertEquals(expected, result);

    }

    @ParameterizedTest
    @MethodSource("increment")
    void incrementBy(int expected, VisitorCounter visitorCounter, int increment) {
        visitorCounter.incrementBy(increment);
        int result = visitorCounter.getCount();
        Assertions.assertEquals(expected, result);
    }
}