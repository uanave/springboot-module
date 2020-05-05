package academy.everyonecodes.scheduling.scheduling;

import academy.everyonecodes.scheduling.service.PrintingService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableAsync
public class Scheduler {
    private final PrintingService printingService;

    public Scheduler(PrintingService printingService) {
        this.printingService = printingService;
    }

    @Async
    @Scheduled(fixedDelayString = "${printing-service.fixedDelay}")
    public void printDelay() {
        printingService.printDelay();
    }

    @Async
    @Scheduled(fixedRateString = "${printing-service.fixedRate}")
    public void printRate() {
        printingService.printFixedRate();
    }

    @Async
    @Scheduled(cron = "${printing-service.cron}")
    public void printCron() {
        printingService.printCron();
    }

}
