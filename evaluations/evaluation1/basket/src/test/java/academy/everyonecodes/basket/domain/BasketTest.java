package academy.everyonecodes.basket.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {
    List<Summary> summaries;
    Basket basket;

    @BeforeEach
    void setup() {
        summaries = new ArrayList<>();
        basket = new Basket(summaries);
    }

    @Test
    void add() {
        assertTrue(summaries.isEmpty());

        Summary summary = new Summary("test", "test", 2.0, 0.0, 2.0);

        basket.add(summary);

        assertFalse(summaries.isEmpty());
        assertEquals(1, summaries.size());

        Summary addedSummary = summaries.get(0);
        assertEquals(addedSummary, summary);
    }

    @Test
    void findAll() {
        assertTrue(summaries.isEmpty());

        List<Summary> result = basket.findAll();

        assertTrue(result.isEmpty());
    }
}