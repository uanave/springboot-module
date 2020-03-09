package academy.everyonecodes.calculator;

import org.springframework.stereotype.Service;

@Service
public class Addition extends Calculation {
    public Addition() {
        super("+");
    }

    @Override
    public double calculate(Expression expression) {
        return expression.getTerm1() + expression.getTerm2();
    }
}
