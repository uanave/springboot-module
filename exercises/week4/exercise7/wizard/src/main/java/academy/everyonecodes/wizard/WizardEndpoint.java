package academy.everyonecodes.wizard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wizard")
public class WizardEndpoint {

    @GetMapping
    String get() {
        return "http://localhost:9002/home";
    }
}
