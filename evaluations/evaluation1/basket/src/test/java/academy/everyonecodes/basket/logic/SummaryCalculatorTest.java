package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.communication.client.UsersClient;
import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.domain.Summary;
import academy.everyonecodes.basket.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class SummaryCalculatorTest {

    @Autowired
    SummaryCalculator summaryCalculator;

    @MockBean
    UsersClient usersClient;

    ItemSelection itemSelection = new ItemSelection("test", "test", 3.0);
    String email = itemSelection.getUserEmail();


    @Test
    void calculateSummary() {
        when(usersClient.get(email)).thenReturn(Optional.of(new User("test", "standard account")));

        Summary result = summaryCalculator.calculateSummary(itemSelection);

        Summary expected = new Summary("test", "test", 3.0, 2.5, 5.5);

        assertEquals(expected, result);
        verify(usersClient).get(email);
    }

    @Test
    void getDeliveryCost() {
        when(usersClient.get(email)).thenReturn(Optional.of(new User("test", "premium account")));

        ItemSelection itemSelection = new ItemSelection("test", "test", 3.0);
        double result = summaryCalculator.getDeliveryCost(itemSelection);
        double expected = 0.0;

        assertEquals(expected, result);
        verify(usersClient).get(email);
    }

    @Test
    void getSummary() {
        double deliveryCost = 2.5;

        Summary result = summaryCalculator.getSummary(itemSelection, deliveryCost);
        Summary expected = new Summary("test", "test", 3.0, 2.5, 5.5);
        assertEquals(expected, result);
    }
}