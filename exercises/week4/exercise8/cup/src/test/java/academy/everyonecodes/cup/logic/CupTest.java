package academy.everyonecodes.cup.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CupTest {
    private Cup cup = new Cup();

    @Test
    void hasCoin() {
        assertFalse(cup.hasCoin());
        cup.putCoin();
        assertTrue(cup.hasCoin());
    }

    @Test
    void putCoin() {
        cup.putCoin();
        assertTrue(cup.hasCoin());
    }

    @Test
    void removeCoin() {
        cup.removeCoin();
        assertFalse(cup.hasCoin());
    }
}