package academy.everyonecodes.fleamarket;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class FleaMarketService {

    private List<Item> items = new ArrayList<>();

    public FleaMarketService(List<Item> items) {
        this.items = items;
    }

    public void add(Item item) {
        items.add(item);
    }

    public List<Item> findByName(String name) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .collect(toList());
    }

    public List<Item> getAll() {
        return items;
    }
}
