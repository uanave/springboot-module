package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.communication.client.UsersClient;
import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.domain.Summary;
import academy.everyonecodes.basket.domain.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SummaryCalculator {

    private final UsersClient usersClient;

    public SummaryCalculator(UsersClient usersClient) {
        this.usersClient = usersClient;
    }

    public Summary calculateSummary(ItemSelection itemSelection) {
        double deliveryCost = getDeliveryCost(itemSelection);
        return getSummary(itemSelection, deliveryCost);
    }

    double getDeliveryCost(ItemSelection itemSelection) {
        String email = itemSelection.getUserEmail();
        Optional<User> user = usersClient.get(email);
        double deliveryCost = 0.0;
        if (user.isEmpty() || !user.get().getAccountType().equals("premium account")) {
            deliveryCost = 2.5;
        }
        return deliveryCost;
    }

    Summary getSummary(ItemSelection itemSelection, double deliveryCost) {
        String email = itemSelection.getUserEmail();
        String itemName = itemSelection.getItemName();
        double itemPrice = itemSelection.getItemPrice();
        double totalPrice = itemPrice + deliveryCost;
        return new Summary(email, itemName, itemPrice, deliveryCost, totalPrice);
    }
}
