package academy.everyonecodes.rockscissorspaper;

import org.springframework.stereotype.Service;

@Service
public class Judge {
    public String judge(Move move1, Move move2) {
        if (move1.getDefeats().equals(move2.getName())) {

            return "You won!";
        }
        if (move2.getDefeats().equals(move1.getName())) {
            return "You lost!";
        }
        return "It's a tie!";
    }
}
