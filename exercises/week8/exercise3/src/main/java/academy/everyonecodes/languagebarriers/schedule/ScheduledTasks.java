package academy.everyonecodes.languagebarriers.schedule;

import academy.everyonecodes.languagebarriers.logic.VisitorCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@Configuration
@EnableScheduling
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private final VisitorCounter visitorCounter;
    private final int amount;

    public ScheduledTasks(VisitorCounter visitorCounter, @Value("${interactions.amount}") int amount) {
        this.visitorCounter = visitorCounter;
        this.amount = amount;
    }

    @Scheduled(fixedDelayString = "${interactions.delay}")
    public void scheduleTaskWithFixedRate() {
        visitorCounter.incrementBy(amount);
        logger.info("Current Number of Visitors: {}", visitorCounter.getCount());
    }
}
