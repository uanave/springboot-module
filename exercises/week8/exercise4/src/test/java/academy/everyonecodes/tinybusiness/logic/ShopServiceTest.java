package academy.everyonecodes.tinybusiness.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopServiceTest {
    ShopService shopService = new ShopService();

    @Test
    void close() {
        shopService.close();
        Assertions.assertFalse(shopService.isOpen());
    }

    @Test
    void open() {
        shopService.open();
        Assertions.assertTrue(shopService.isOpen());
    }
}