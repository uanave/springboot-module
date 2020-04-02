package academy.everyonecodes.marathonintegration.configuration;

import academy.everyonecodes.marathonintegration.domain.Runner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.List;

@Configuration
public class RunnerConfiguration {

    @Bean
    Runner winner() {
        return new Runner("John", Duration.ofMinutes(3));
    }

    @Bean
    List<Runner> runners() {
        Runner runner1 = new Runner("John", Duration.ofMinutes(3));
        Runner runner2 = new Runner("Tom", Duration.ofMinutes(7));
        return List.of(runner1, runner2);
    }
}
