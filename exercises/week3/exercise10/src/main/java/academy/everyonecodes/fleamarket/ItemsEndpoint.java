package academy.everyonecodes.fleamarket;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemsEndpoint {
    private List<Item> items = new ArrayList<>();

    public ItemsEndpoint(List<Item> items) {
        this.items = items;
    }

    @GetMapping
    List<Item> getItems() {
        return items;
    }

    @PostMapping
    Item postItem(@RequestBody Item item) {
        items.add(item);
        return item;
    }

    @GetMapping("/{name}")
    List<Item> getByName(@PathVariable String name) {
        return items.stream()
                .filter(item -> item.getName().equals(name))
                .collect(Collectors.toList());
    }
}
