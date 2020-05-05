package academy.everyonecodes.scheduling.service;

import org.springframework.stereotype.Service;

@Service
public class PrintingService {

    public void printDelay() {
        System.out.println("Fixed delay message every 5 seconds");
    }

    public void printFixedRate() {
        System.out.println("Fixed rate message every 2 seconds.");
    }

    public void printCron() {
        System.out.println("Cron message every interval.");
    }

}
