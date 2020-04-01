package academy.everyonecodes.complexformula;


import academy.everyonecodes.complexformula.communication.client.FormulaClient;
import academy.everyonecodes.complexformula.logic.ComplexFormula;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ComplexFormulaTest {

    @Autowired
    ComplexFormula complexFormula;

    @MockBean
    FormulaClient formulaClient;

    @Test
    void applyFormula() {
        int input = 2;
        int expected = 4;
        Mockito.when(formulaClient.apply(input)).thenReturn(expected);

        int result = complexFormula.applyFormula(input);

        assertEquals(expected, result);
        Mockito.verify(formulaClient).apply(input);
    }
}