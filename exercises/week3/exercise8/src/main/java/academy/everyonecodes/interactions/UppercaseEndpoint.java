package academy.everyonecodes.interactions;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uppercase")
public class UppercaseEndpoint {

    @PostMapping
    String post(@RequestBody String text) {
        return text.toUpperCase();
    }
}


