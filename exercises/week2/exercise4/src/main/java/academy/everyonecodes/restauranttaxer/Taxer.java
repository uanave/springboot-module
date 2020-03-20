package academy.everyonecodes.restauranttaxer;

import java.util.List;

public abstract class Taxer {
    private List<String> dishes;
    private double tax;

    public Taxer(List<String> dishes, double tax) {
        this.dishes = dishes;
        this.tax = tax;
    }

    public List<String> getDishes() {
        return dishes;
    }

    public double getTax() {
        return tax;
    }

    public boolean matches(RestaurantDish dish) {
        return dishes.contains(dish.getName());
    }
    public double tax(RestaurantDish dish) {
        return dish.getPrice() * tax;
    }

}
