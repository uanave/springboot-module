package academy.everyonecodes.restauranttaxer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeverageTaxer extends Taxer {

    public BeverageTaxer(@Value("${restaurant.beverages.names}") List<String> dishes, @Value("${restaurant.beverages.tax}") double tax) {
        super(dishes, tax);
    }
}
