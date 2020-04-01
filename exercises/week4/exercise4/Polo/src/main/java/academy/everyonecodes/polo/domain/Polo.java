package academy.everyonecodes.polo.domain;

import org.springframework.stereotype.Service;

@Service
public class Polo {
    public String readText(String message) {
        return (message.equals("Marco")) ? "Polo" : "What?";
/*        if (message.equals("Marco")) {
            return "Polo";
        }
        return "What?";
        */
    }
}
