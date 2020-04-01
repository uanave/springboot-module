package academy.everyonecodes.complexformula;

import academy.everyonecodes.complexformula.communication.client.FormulaClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
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

        Mockito.when(restTemplate.postForObject(url + "/formula", number, Integer.class)).thenReturn(44);

        formulaClient.apply(number);

        Mockito.verify(restTemplate).postForObject(url + "/formula", number, Integer.class);
    }
}