package academy.everyonecodes.trickster.logic;

import academy.everyonecodes.trickster.communication.client.CupsClient;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Trickster {
    private final CupsClient cupsClient;
    private final Random random;

    public Trickster(CupsClient cupsClient, Random random) {
        this.cupsClient = cupsClient;
        this.random = random;
    }

    public String startGame() {
        emptyCups();
        int rand = random.nextInt(cupsClient.getCups());
        System.out.println(rand);
        cupsClient.placeCoin(rand);
        return "The cups have been shuffled!";
    }

    void emptyCups() {
        int cupNumber = cupsClient.getCups();
        while (cupNumber > 0) {
            cupsClient.removeCoin(cupNumber - 1);
            cupNumber--;
        }
    }

    public boolean hasCoin(int cupNumber) {
        return cupsClient.hasCoin(cupNumber);
    }
}
