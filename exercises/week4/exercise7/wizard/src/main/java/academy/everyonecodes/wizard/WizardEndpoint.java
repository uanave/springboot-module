package academy.everyonecodes.wizard;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wizard")
public class WizardEndpoint {

    @PostMapping
    String post() {
        return "http://localhost:9002/home";
    }
}
