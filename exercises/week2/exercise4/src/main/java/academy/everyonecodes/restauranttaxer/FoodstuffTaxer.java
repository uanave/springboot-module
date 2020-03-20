package academy.everyonecodes.restauranttaxer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodstuffTaxer extends Taxer {

    public FoodstuffTaxer(@Value("${restaurant.foodstuff.names}") List<String> dishes,
                          @Value("${restaurant.foodstuff.tax}") double tax) {
        super(dishes, tax);
    }

    @Override
    public boolean matches(RestaurantDish restaurantDish) {
        return getDishes().contains(restaurantDish.getName());
    }

    @Override
    public double tax(RestaurantDish dish) {
        return dish.getPrice() + getTax();
    }
}
