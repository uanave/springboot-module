package academy.everyonecodes.complexformula;

import academy.everyonecodes.complexformula.communication.client.FormulaClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class FormulaClientTest {

    @Autowired
    FormulaClient formulaClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${interactions.url}")
    String url;


    @Test
    void post() {
        int number = 22;

        formulaClient.apply(number);

        verify(restTemplate).postForObject(url, number, Integer.class);
    }
}