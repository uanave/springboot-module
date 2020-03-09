package academy.everyonecodes.calculator;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpressionParser {
    public Optional<Expression> parse(String input) {
        List<String> inputAsList = List.of(input.split(" "));
        if (inputAsList.size() != 3) {
            return Optional.empty();
        }
        String symbol = inputAsList.get(1);

        try {
            double number1 = Double.parseDouble(inputAsList.get(0));
            double number2 = Double.parseDouble(inputAsList.get(2));
            Expression expression = new Expression(symbol, number1, number2);
            return Optional.of(expression);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
