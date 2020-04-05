package academy.everyonecodes.home;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeEndpoint {


    private final String message;

    public HomeEndpoint(@Value("${message}") String message) {
        this.message = message;
    }


    @GetMapping
    String get() {
        return message;
    }
}
