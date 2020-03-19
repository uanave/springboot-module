package academy.everyonecodes.basicproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NaturalNumber {

    private int number;

    public NaturalNumber(@Value("${basic.naturalnumber}") int number) {
        this.number = number;
    }

    public int get() {
        return number;
    }
}
