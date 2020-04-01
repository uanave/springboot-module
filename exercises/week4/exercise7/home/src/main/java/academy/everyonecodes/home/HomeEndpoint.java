package academy.everyonecodes.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeEndpoint {

    @GetMapping
    String get() {
        return "Kansas";
    }
}
