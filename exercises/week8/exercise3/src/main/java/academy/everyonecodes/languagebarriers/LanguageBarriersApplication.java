package academy.everyonecodes.languagebarriers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LanguageBarriersApplication {

    public static void main(String[] args) {
        SpringApplication.run(LanguageBarriersApplication.class, args);
    }
}
