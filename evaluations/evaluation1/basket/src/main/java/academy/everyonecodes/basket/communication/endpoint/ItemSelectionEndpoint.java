package academy.everyonecodes.basket.communication.endpoint;

import academy.everyonecodes.basket.domain.Basket;
import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.domain.Summary;
import academy.everyonecodes.basket.logic.SummaryCalculator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemselections")
public class ItemSelectionEndpoint {
    private final SummaryCalculator summaryCalculator;
    private final Basket basket;

    public ItemSelectionEndpoint(SummaryCalculator summaryCalculator, Basket basket) {
        this.summaryCalculator = summaryCalculator;
        this.basket = basket;
    }

    @PostMapping
    ItemSelection post(@RequestBody ItemSelection itemSelection) {
        Summary summary = summaryCalculator.calculateSummary(itemSelection);
        basket.add(summary);
        return itemSelection;
    }
}
