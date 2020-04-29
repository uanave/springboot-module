package academy.everyonecodes.languagebarriers.logic;

import org.springframework.stereotype.Service;

@Service
public class VisitorCounter {
    private int count;

    public VisitorCounter() {
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }

    public void incrementBy(int increase) {
        count += increase;
    }
}
