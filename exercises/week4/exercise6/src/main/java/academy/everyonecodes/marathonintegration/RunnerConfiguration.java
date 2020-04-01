package academy.everyonecodes.marathonintegration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.List;

@Configuration
public class RunnerConfiguration {

    @Bean
    Runner winner() {
        return new Runner("Ion", Duration.ofMinutes(3));
    }

    @Bean
    List<Runner> runners() {
        Runner runner1 = new Runner("Ion", Duration.ofMinutes(3));
        Runner runner2 = new Runner("Vasile", Duration.ofMinutes(7));
        return List.of(runner1, runner2);
    }
}
