package academy.everyonecodes.complexformula;

import academy.everyonecodes.complexformula.logic.ComplexFormula;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ComplexFormulaEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    ComplexFormula complexFormula;

    @Test
    void get() {
        int number = 22;
        String url = "/complexformula/" + number;
        testRestTemplate.getForObject(url, Integer.class);
        Mockito.verify(complexFormula).applyFormula(number);
    }
}
