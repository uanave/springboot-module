package academy.everyonecodes.marcopolo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{text}")
public class MarcoPoloEndpoint {

    @GetMapping
    String getText(@PathVariable String text) {
        if (text.equals("Marco")) {
            return "Polo";
        }
        return "What?";
    }
}
