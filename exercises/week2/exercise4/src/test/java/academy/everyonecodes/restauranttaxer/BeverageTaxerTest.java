package academy.everyonecodes.restauranttaxer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BeverageTaxerTest {

    @Autowired
    BeverageTaxer beverageTaxer;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(true, new RestaurantDish("soda", 2)),
                Arguments.of(false, new RestaurantDish("wine", 3))
        );
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(3.2, new RestaurantDish("soda", 2))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void matches(boolean expected, RestaurantDish input) {
        boolean result = beverageTaxer.matches(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void tax(double expected, RestaurantDish input) {
        double result = beverageTaxer.tax(input);
        assertEquals(expected, result);
    }
}