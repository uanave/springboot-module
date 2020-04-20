package academy.everyonecodes.basket.communication.endpoint;

import academy.everyonecodes.basket.domain.Basket;
import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.domain.Summary;
import academy.everyonecodes.basket.domain.User;
import academy.everyonecodes.basket.logic.SummaryCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ItemSelectionEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    SummaryCalculator summaryCalculator;

    @MockBean
    Basket basket;

    @Test
    void post() {
        String url = "/itemselections";
        ItemSelection itemSelection = new ItemSelection("test", "test", 3.0);
        Summary summary = new Summary("test", "test", 3.0, 0.0, 3.0);

        when(summaryCalculator.calculate(itemSelection)).thenReturn(summary);

        testRestTemplate.postForObject(url, itemSelection, User.class);

        verify(summaryCalculator).calculate(itemSelection);

        verify(basket).add(summary);
    }
}