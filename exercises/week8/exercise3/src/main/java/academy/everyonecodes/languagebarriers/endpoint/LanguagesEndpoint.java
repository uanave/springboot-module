package academy.everyonecodes.languagebarriers.endpoint;

import academy.everyonecodes.languagebarriers.logic.VisitorCounter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LanguagesEndpoint {
    private final VisitorCounter visitorCounter;
    private final String generalMessage;
    private final String availableLanguages;
    private final String german;
    private final String english;

    public LanguagesEndpoint(VisitorCounter visitorCounter,
                             @Value("${messages.general}") String generalMessage,
                             @Value("${messages.available}") String availableLanguages,
                             @Value("${messages.german}") String german,
                             @Value("${messages.english}") String english) {
        this.visitorCounter = visitorCounter;
        this.generalMessage = generalMessage;
        this.availableLanguages = availableLanguages;
        this.german = german;
        this.english = english;
    }

    @GetMapping
    String getMessage() {
        return generalMessage;
    }

    @GetMapping("/languages")
    @Secured("ROLE_USER")
    String getAvailableLanguages() {
        visitorCounter.increment();
        return availableLanguages;
    }

    @GetMapping("/languages/german")
    @Secured("ROLE_LANGUAGE_GERMAN")
    String getGerman() {
        visitorCounter.increment();
        return german;
    }

    @GetMapping("/languages/english")
    @Secured("ROLE_LANGUAGE_ENGLISH")
    String getEnglish() {
        visitorCounter.increment();
        return english;
    }

    @GetMapping("/interactions")
    @Secured("ROLE_ADMIN")
    int getInteractions() {
        return visitorCounter.getCount();
    }
}
