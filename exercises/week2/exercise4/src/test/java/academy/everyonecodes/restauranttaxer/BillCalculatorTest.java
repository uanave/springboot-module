package academy.everyonecodes.restauranttaxer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BillCalculatorTest {

    @Autowired
    BillCalculator billCalculator;

    static Stream<Arguments> parameters() {
        List<RestaurantDish> dishes = List.of(
                new RestaurantDish("potato soup", 5),
                new RestaurantDish("pizza", 9),
                new RestaurantDish("soda", 2),
                new RestaurantDish("wine", 3)
        );

        return Stream.of(
                Arguments.of(21.30, dishes)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(double expected, List<RestaurantDish> dishes) {
        double result = billCalculator.calculate(dishes);
        assertEquals(expected, result);
    }
}