package academy.everyonecodes.thefinalcountdown;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TheFinalCountdownRunner {

    @Bean
    ApplicationRunner run(CountdownManager countdownManager) {
        return args -> countdownManager.countdown();


    }
}
        /*return args -> {
            List<Countdown> countdowns = countdownManager.findAll();
            if (countdowns.isEmpty()) {
                Countdown countdown = new Countdown(3);
                countdownManager.save(countdown);
                System.out.println("Countdown: " + countdown.getCount());
            } else {
                Countdown current = countdowns.get(0);
                int count = current.getCount();
                count--;
                if (count > 0) {
                    System.out.println("Countdown: " + count);
                    current.setCount(count);
                    countdownManager.save(current);
                } else if (count == 0) {
                    countdownManager.delete(current);
                    List<Accumulation> accumulations = accumulationManager.findAll();
                    if (accumulations.isEmpty()) {
                        Accumulation accumulation = new Accumulation(1);
                        accumulationManager.save(accumulation);
                        System.out.println("Times that the countdown went off: " + accumulation.getTimes());
                    } else {
                        Accumulation accumulation = accumulations.get(0);
                        int times = accumulation.getTimes();
                        accumulation.setTimes(times + 1);
                        accumulationManager.save(accumulation);
                        System.out.println("Times that the countdown went off: " + accumulation.getTimes());
                    }
                }
            }
        };*/
