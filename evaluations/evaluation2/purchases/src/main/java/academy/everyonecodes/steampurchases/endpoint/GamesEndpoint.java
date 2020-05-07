package academy.everyonecodes.steampurchases.endpoint;

import academy.everyonecodes.steampurchases.persistence.domain.Game;
import academy.everyonecodes.steampurchases.logic.PurchaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GamesEndpoint {
    private final PurchaseService purchaseService;

    public GamesEndpoint(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    List<Game> getAllGames() {
        return purchaseService.findAllGames();
    }
}
