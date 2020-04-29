package academy.everyonecodes.nevertoolate.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class NeverTooLateEndpoint {
    private final String message;

    public NeverTooLateEndpoint(@Value("${webapp.message}") String message) {
        this.message = message;
    }

    @GetMapping
    String get() {
        return message;
    }
}
