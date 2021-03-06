package academy.everyonecodes.complexformula.logic;

import academy.everyonecodes.complexformula.communication.client.FormulaClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplexFormula {
    private final FormulaClient formulaClient;

    public ComplexFormula(FormulaClient formulaClient) {
        this.formulaClient = formulaClient;
    }

    public int applyFormula(Integer number) {
        List<String> digits = List.of(String.valueOf(number).split(""));
        String result = digits.stream()
                .map(digit -> String.valueOf(formulaClient.apply(Integer.parseInt(digit))))
                .collect(Collectors.joining(""));
        return Integer.parseInt(result);
    }
}
