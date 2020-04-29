package academy.everyonecodes.securedpolo.logic;

import org.springframework.stereotype.Service;

@Service
public class PoloService {
    public String transformMessage(String text) {
        return (text.equals("Marco")) ? "Polo" : "What?";
    }
}
