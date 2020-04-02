package academy.everyonecodes.cup.logic;

import org.springframework.stereotype.Service;

@Service
public class Cup {
    private boolean isCoin = false;

    public boolean hasCoin() {
        return isCoin;
    }

    public void putCoin() {
        isCoin = true;
    }

    public void removeCoin() {
        isCoin = false;
    }
}
