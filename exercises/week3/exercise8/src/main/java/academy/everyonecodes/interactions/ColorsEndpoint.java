package academy.everyonecodes.interactions;

import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/colors")
public class ColorsEndpoint {
    private Set<String> colors = new HashSet<>();

    @GetMapping
    Set<String> getColors() {
        return colors;
    }

    @GetMapping("/{name}")
    String get(@PathVariable String name) {
        return colors.stream()
                .filter(color -> color.equalsIgnoreCase(name))
                .findFirst()
                .orElse("The color is not available in the app");
    }

    @PostMapping
    String post(@RequestBody String text) {
        colors.add(text);
        return text;
    }

    @PutMapping("/{target}")
    String put(@PathVariable String target, @RequestBody String replacement) {
        colors.remove(target);
        colors.add(replacement);
        return replacement;
    }

    @DeleteMapping
    void deleteAll() {
        colors.clear();
    }

    @DeleteMapping("/{name}")
    void deleteOne(@PathVariable String name) {
        colors.remove(name);
    }

}
