package academy.everyonecodes.calculator;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Calculator {
    private final ExpressionParser parser;
    private final List<Calculation> calculations;

    public Calculator(ExpressionParser parser, List<Calculation> calculations) {
        this.parser = parser;
        this.calculations = calculations;
    }

    public double calculate(String input) {
        Optional<Expression> oExpression = parser.parse(input);
        Expression expression = oExpression.orElseThrow(IllegalArgumentException::new);
        return calculations.stream()
                .filter(calculation -> calculation.matches(expression))
                .map(calculation -> calculation.calculate(expression))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

