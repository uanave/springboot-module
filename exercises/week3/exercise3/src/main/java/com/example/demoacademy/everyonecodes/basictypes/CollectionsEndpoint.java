package com.example.demoacademy.everyonecodes.basictypes;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/collections")
public class CollectionsEndpoint {

    @GetMapping("/texts")
    List<String> getTexts() {
        return List.of("a", "b", "c");
    }

    @GetMapping("/numbers")
    List<Integer> getNumbers() {
        return Set.of(1, 2, 3);
    }

    @GetMapping("/choices")
    Map<String, Boolean> getMap() {
        return Map.of("do this", true, "do that", false);
    }
}
