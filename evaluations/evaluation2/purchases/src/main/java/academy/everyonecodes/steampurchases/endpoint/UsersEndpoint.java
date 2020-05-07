package academy.everyonecodes.steampurchases.endpoint;

import academy.everyonecodes.steampurchases.persistence.domain.User;
import academy.everyonecodes.steampurchases.logic.PurchaseService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@Secured("ROLE_ADMIN")
public class UsersEndpoint {
    private final PurchaseService purchaseService;

    public UsersEndpoint(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    List<User> getAllUsers() {
        return purchaseService.findAllUsers();
    }
}
