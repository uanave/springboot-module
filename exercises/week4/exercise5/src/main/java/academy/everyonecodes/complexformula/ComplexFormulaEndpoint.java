package academy.everyonecodes.complexformula;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complexformula")
public class ComplexFormulaEndpoint {
    private final ComplexFormula complexFormula;

    public ComplexFormulaEndpoint(ComplexFormula complexFormula) {
        this.complexFormula = complexFormula;
    }

    @GetMapping("/{number}")
    int get(@PathVariable int number) {
        return complexFormula.applyFormula(number);
    }
}
