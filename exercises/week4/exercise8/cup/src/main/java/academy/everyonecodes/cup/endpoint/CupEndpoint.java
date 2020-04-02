package academy.everyonecodes.cup.endpoint;

import academy.everyonecodes.cup.logic.Cup;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cup")
public class CupEndpoint {

    private final Cup cup;

    public CupEndpoint(Cup cup) {
        this.cup = cup;
    }

    @GetMapping
    boolean get() {
        return cup.hasCoin();
    }

    @PutMapping
    void put() {
        cup.putCoin();
    }

    @DeleteMapping
    void delete() {
        cup.removeCoin();
    }
}
