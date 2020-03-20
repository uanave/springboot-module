package academy.everyonecodes.restauranttaxer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FoodstuffTaxerTest {

    @Autowired
    FoodstuffTaxer taxer;

    @ParameterizedTest
    @CsvSource({
            "false, ''",
            "false, wrong-dish",
            "true, tiramisu",
    })
    void matches(boolean expected, String name) {
        RestaurantDish dish = new RestaurantDish(name, 1.0);

        boolean result = taxer.matches(dish);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, 0.0",
            "1.10, 1.0",
            "2.20, 2.0",
    })
    void tax(double expected, double price) {
        RestaurantDish dish = new RestaurantDish("name", price);

        double result = taxer.tax(dish);

        assertEquals(expected, result);
    }
}
