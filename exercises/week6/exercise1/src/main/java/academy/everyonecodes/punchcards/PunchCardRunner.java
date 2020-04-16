package academy.everyonecodes.punchcards;


import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class PunchCardRunner {

    @Bean
    ApplicationRunner runPunchCards(PunchCardService punchCardService) {
        return args -> punchCardService.punch();
    }

    /*@Bean
    ApplicationRunner runPunchCards(PunchCardService punchCardService) {
        return args -> {
            LocalDateTime local = LocalDateTime.now();
            PunchCard punchCard = new PunchCard(local.getDayOfWeek().toString(), (local.format(DateTimeFormatter.ISO_TIME)));
            System.out.println("PunchCard created: " + punchCard);
            punchCardService.save(punchCard);
            System.out.println("PunchCard saved: " + punchCard);
        };
    }*/
}
