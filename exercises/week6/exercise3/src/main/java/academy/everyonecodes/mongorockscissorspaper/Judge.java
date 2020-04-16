package academy.everyonecodes.mongorockscissorspaper;

import org.springframework.stereotype.Service;

@Service
public class Judge {
    public String judge(Move move1, Move move2) {
        if (move1.getDefeats().equals(move2.getName())) {

            return "Player 1 won!";
        }
        if (move2.getDefeats().equals(move1.getName())) {
            return "Player 2 lost!";
        }
        return "It's a tie!";
    }
}
