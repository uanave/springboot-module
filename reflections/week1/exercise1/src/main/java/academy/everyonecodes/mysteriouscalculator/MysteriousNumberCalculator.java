package academy.everyonecodes.mysteriouscalculator;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MysteriousNumberCalculator {
    private final Set<MysteriousAddition> additions;
    private final MysteriousNumberFormatter formatter;

    public MysteriousNumberCalculator(Set<MysteriousAddition> additions, MysteriousNumberFormatter formatter) {
        this.additions = additions;
        this.formatter = formatter;
    }

    public String calculate(int number) {
        int result = additions.stream()
                .map(mysteriousAddition -> mysteriousAddition.apply(number))
                .mapToInt(Integer::intValue)
                .sum()-number;
        return formatter.format(result);

    }
}
