package academy.everyonecodes.thefinalcountdown;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CountdownManager {
    private final CountdownRepository countdownRepository;
    private final AccumulationManager accumulationManager;
    private final int countdownStart;

    public CountdownManager(CountdownRepository countdownRepository, AccumulationManager accumulationManager,
                            @Value("${countdown.start}") int countdownStart) {
        this.countdownRepository = countdownRepository;
        this.accumulationManager = accumulationManager;
        this.countdownStart = countdownStart;
    }

    public void countdown() {
        if (doesNotExistCountdown()) {
            createCountdown();
            return;
        }
        decreaseCountdown();
    }

    private boolean doesNotExistCountdown() {
        return countdownRepository.count() == 0;
    }

    private void createCountdown() {
        Countdown countdown = new Countdown(countdownStart);
        countdownRepository.save(countdown);
        System.out.println("Countdown: " + countdown.getCount());
    }

    private void decreaseCountdown() {
        Countdown countdown = countdownRepository.findAll().get(0);
        int nextCount = countdown.getCount() - 1;
        countdown.setCount(nextCount);
        if (isConcluded(countdown)) {
            delete(countdown);
            return;
        }
        countdownRepository.save(countdown);
        System.out.println("Countdown: " + countdown.getCount());
    }

    private boolean isConcluded(Countdown countdown) {
        return countdown.getCount() == 0;
    }

    private void delete(Countdown countdown) {
        countdownRepository.delete(countdown);
        accumulationManager.accumulate();
    }
}


    /*private CountdownRepository countdownRepository;

    public CountdownManager(CountdownRepository countdownRepository) {
        this.countdownRepository = countdownRepository;
    }

    public Countdown save(Countdown countdown) {
        countdownRepository.save(countdown);
        return countdown;
    }

    public List<Countdown> findAll() {
        return countdownRepository.findAll();
    }

    public void delete(Countdown countdown) {
        countdownRepository.delete(countdown);
    }*/

