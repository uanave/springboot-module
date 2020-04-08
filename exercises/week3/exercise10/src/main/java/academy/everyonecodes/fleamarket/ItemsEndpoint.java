package academy.everyonecodes.fleamarket;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsEndpoint {
    private final FleaMarketService fleaMarketService;

    public ItemsEndpoint(FleaMarketService fleaMarketService) {
        this.fleaMarketService = fleaMarketService;
    }

    @GetMapping
    List<Item> getItems() {
        return fleaMarketService.getAll();
    }

    @PostMapping
    Item postItem(@RequestBody Item item) {
        fleaMarketService.add(item);
        return item;
    }

    @GetMapping("/{name}")
    List<Item> getByName(@PathVariable String name) {
        return fleaMarketService.findByName(name);
    }
}
