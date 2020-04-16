package academy.everyonecodes.mongorockscissorspaper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Judge {
    private String resultPlayer1;
    private String resultPlayer2;
    private String resultTie;

    public Judge(@Value("${results.player1}") String resultPlayer1,
                 @Value("${results.player2}") String resultPlayer2,
                 @Value("${results.tie}") String resultTie) {
        this.resultPlayer1 = resultPlayer1;
        this.resultPlayer2 = resultPlayer2;
        this.resultTie = resultTie;
    }

    public String judge(Move move1, Move move2) {
        if (move1.getDefeats().equals(move2.getName())) {

            return resultPlayer1;
        }
        if (move2.getDefeats().equals(move1.getName())) {
            return resultPlayer2;
        }
        return resultTie;
    }
}
