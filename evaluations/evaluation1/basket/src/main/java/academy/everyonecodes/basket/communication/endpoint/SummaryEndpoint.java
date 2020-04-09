package academy.everyonecodes.basket.communication.endpoint;

import academy.everyonecodes.basket.domain.Basket;
import academy.everyonecodes.basket.domain.Summary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/summaries")
public class SummaryEndpoint {
    private final Basket basket;

    public SummaryEndpoint(Basket basket) {
        this.basket = basket;
    }

    @GetMapping
    List<Summary> getSummaries() {
        return basket.findAll();
    }
}
