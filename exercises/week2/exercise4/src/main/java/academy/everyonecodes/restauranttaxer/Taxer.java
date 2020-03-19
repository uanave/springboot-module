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

    public abstract boolean matches(RestaurantDish dish);

    public abstract double tax(RestaurantDish dish);
}
