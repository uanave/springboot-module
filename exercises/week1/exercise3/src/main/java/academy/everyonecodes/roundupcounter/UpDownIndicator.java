package academy.everyonecodes.roundupcounter;

import org.springframework.stereotype.Service;

@Service
public class UpDownIndicator {
    private Rounder rounder;

    public UpDownIndicator(Rounder rounder) {
        this.rounder = rounder;
    }

    public String indicate(double number) {
        double up = rounder.roundUp(number);
        double down = rounder.roundDown(number);
        double resultUp = up - number;
        double resultDown = number - down;
        if (resultUp == resultDown) {
            return "SAME";
        } else if (resultUp > 0.5) {
            return "DOWN";
        }
        return "UP";
    }
}
