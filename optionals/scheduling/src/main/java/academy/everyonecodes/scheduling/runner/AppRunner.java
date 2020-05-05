package academy.everyonecodes.scheduling.runner;

import academy.everyonecodes.scheduling.scheduling.Scheduler;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppRunner {

    @Bean
    ApplicationRunner runScheduledTasks(Scheduler scheduler) {
        return args -> {
            scheduler.printRate();
            scheduler.printDelay();
            scheduler.printCron();
        };
    }
}
