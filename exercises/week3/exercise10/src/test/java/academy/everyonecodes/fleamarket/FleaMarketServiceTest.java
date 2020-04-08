package academy.everyonecodes.fleamarket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;

class FleaMarketServiceTest {
    FleaMarketService fleaMarketService;
    List<Item> items;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(), List.of(), "item not present"),
                Arguments.of(List.of(), List.of(new Item("test", 0.0)), "item not present"),
                Arguments.of(List.of(new Item("test", 0.0)), List.of(new Item("test", 0.0)), "test"),
                Arguments.of(List.of(new Item("test", 0.0),
                        new Item("test", 1.0)),
                        List.of(new Item("test", 0.0),
                                new Item("test", 1.0)),
                        "test")
        );
    }


    @BeforeEach
    void setup() {
        items = new ArrayList<>();
        fleaMarketService = new FleaMarketService(items);
    }
    @Test
    void add() {
        assertTrue(items.isEmpty());
        Item item = new Item("test", 0.0);

        fleaMarketService.add(item);

        assertFalse(items.isEmpty());
        assertEquals(1, items.size());
        Item addedItem = items.get(0);
        assertEquals(addedItem, item);
    }


    @ParameterizedTest
    @MethodSource("parameters")
    void findByName(List<Item> expected, List<Item> presentItems, String itemName) {
        items.addAll(presentItems);

        List<Item> result = fleaMarketService.findByName(itemName);

        assertEquals(expected, result);
    }


    @Test
    void getAll() {
        assertTrue(items.isEmpty());

        List<Item> result = fleaMarketService.getAll();

        assertTrue(result.isEmpty());
    }
}