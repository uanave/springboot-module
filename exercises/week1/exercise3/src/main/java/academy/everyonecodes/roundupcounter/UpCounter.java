package academy.everyonecodes.roundupcounter;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpCounter {
    private UpDownIndicator indicator;

    public UpCounter(UpDownIndicator indicator) {
        this.indicator = indicator;
    }

    public long count(List<Double> numbers) {
        return numbers.stream()
                .filter(e -> indicator.indicate(e).equals("UP"))
                .count();
    }
}
