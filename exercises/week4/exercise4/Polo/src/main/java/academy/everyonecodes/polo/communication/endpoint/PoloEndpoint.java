package academy.everyonecodes.polo.communication.endpoint;

import academy.everyonecodes.polo.domain.Polo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polo")
public class PoloEndpoint {
    private final Polo polo;

    public PoloEndpoint(Polo polo) {
        this.polo = polo;
    }

    @PostMapping()
    String post(@RequestBody String message) {
        return polo.readText(message);
    }
}
