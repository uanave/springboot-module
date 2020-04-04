package academy.everyonecodes.complexformula;


import academy.everyonecodes.complexformula.communication.client.FormulaClient;
import academy.everyonecodes.complexformula.logic.ComplexFormula;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ComplexFormulaTest {

    @Autowired
    ComplexFormula complexFormula;

    @MockBean
    FormulaClient formulaClient;

    @BeforeEach
    void setup() {
        Mockito.when(formulaClient.apply(anyInt())).thenReturn(1);
    }
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "11, 12",
            "111, 123",
            "1111, 1234",
    })

    void applyFormula(int expected, int number) {
        int result = complexFormula.applyFormula(number);

        assertEquals(expected, result);
    }
}