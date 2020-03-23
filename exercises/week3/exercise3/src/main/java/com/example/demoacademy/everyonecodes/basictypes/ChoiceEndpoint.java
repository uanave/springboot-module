package com.example.demoacademy.everyonecodes.basictypes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/choice")
public class ChoiceEndpoint {
    @GetMapping
    boolean getChoice() {
        return true;
    }
}
