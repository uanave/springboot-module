package academy.everyonecodes.complexformula;


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
        Mockito.when(formulaClient.apply(2)).thenReturn(4);

        int result = complexFormula.applyFormula(2);

        assertEquals(4, result);
        Mockito.verify(formulaClient).apply(2);
    }
}