package academy.everyonecodes.calculator;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Calculator {
    private ExpressionParser parser;
    private List<Calculation> calculations;

    public Calculator(ExpressionParser parser, List<Calculation> calculations) {
        this.parser = parser;
        this.calculations = calculations;
    }

    public ExpressionParser getParser() {
        return parser;
    }

    public void setParser(ExpressionParser parser) {
        this.parser = parser;
    }

    public List<Calculation> getCalculations() {
        return calculations;
    }

    public void setCalculations(List<Calculation> calculations) {
        this.calculations = calculations;
    }

    public Optional<Double> calculate(String expression) throws IllegalArgumentException {
        Optional<Expression> oExpression = parser.parse(expression);
        return oExpression.flatMap(value -> calculations.stream()
                .filter(calculation -> calculation.matches(value))
                .map(calculation -> calculation.calculate(value))
                .findFirst());
    }
}

