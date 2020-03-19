package academy.everyonecodes.restauranttaxer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FoodstuffTaxerTest {

    @Autowired
    FoodstuffTaxer foodstuffTaxer;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(true, new RestaurantDish("potato soup", 5)),
                Arguments.of(false, new RestaurantDish("pizza", 9))
        );
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(6.10, new RestaurantDish("potato soup", 5))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void matches(boolean expected, RestaurantDish input) {
        boolean result = foodstuffTaxer.matches(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void tax(double expected, RestaurantDish input) {
        double result = foodstuffTaxer.tax(input);
        assertEquals(expected, result);
    }
}