package academy.everyonecodes.securedpolo.endpoint;

import academy.everyonecodes.securedpolo.logic.PoloService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/polo")
public class PoloEndpoint {
    private final PoloService poloService;

    public PoloEndpoint(PoloService poloService) {
        this.poloService = poloService;
    }

    @PostMapping()
    String post(@RequestBody String text) {
        return poloService.transformMessage(text);
    }
}
