package academy.everyonecodes.wizard;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wizard")
public class WizardEndpoint {

    private final String home;

    public WizardEndpoint(@Value("${home.url}") String home) {
        this.home = home;
    }

    @GetMapping
    String get() {
        return home;
    }
}
