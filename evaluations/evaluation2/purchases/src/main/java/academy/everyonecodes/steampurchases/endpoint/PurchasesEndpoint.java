package academy.everyonecodes.steampurchases.endpoint;

import academy.everyonecodes.steampurchases.persistence.domain.Purchase;
import academy.everyonecodes.steampurchases.logic.PurchaseService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchases")
@Secured("ROLE_APP")
public class PurchasesEndpoint {
    private final PurchaseService purchaseService;

    public PurchasesEndpoint(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    Purchase save(@RequestBody Purchase purchase) {
        return purchaseService.save(purchase);
    }
}
