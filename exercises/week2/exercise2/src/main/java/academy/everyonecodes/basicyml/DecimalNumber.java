package academy.everyonecodes.basicyml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DecimalNumber {
    private final double number;

    public DecimalNumber(@Value("${basic.decimalnumber}") double number) {
        this.number = number;
    }

    public double get() {
        return number;
    }
}
