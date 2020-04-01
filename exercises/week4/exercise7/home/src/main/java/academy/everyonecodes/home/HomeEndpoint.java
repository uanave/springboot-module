package academy.everyonecodes.home;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeEndpoint {

    @PostMapping
    String getMessage() {
        return "Kansas";
    }
}
