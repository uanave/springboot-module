package academy.everyonecodes.basicproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Message {
    private final String message;

    public Message(@Value("${basic.message}") String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
