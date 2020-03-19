package academy.everyonecodes.rockscissorspaper;

import org.springframework.stereotype.Service;

@Service
public class Game {
    private Player player1;
    private Player player2;
    private Judge judge;

    public Game(Player player1, Player player2, Judge judge) {
        this.player1 = player1;
        this.player2 = player2;
        this.judge = judge;
    }

    public void play() {
        System.out.println("Welcome to the game!");
        boolean wantToPlay = true;
        while (wantToPlay) {
            playOneRound(player1, player2);
            wantToPlay = askToPlayAgain(player1, player2);
        }
        System.out.println("Goodbye");
    }

    private void playOneRound(Player player1, Player player2) {
        Move move1 = player1.play();
        Move move2 = player2.play();
        System.out.println("Player 1 chose: " + move1.getName());
        System.out.println("Player 2 chose: " + move2.getName());
        String result = judge.judge(move1, move2);
        System.out.println(result);
    }

    private boolean askToPlayAgain(Player player1, Player player2) {
        return player1.wantsToPlayAgain() && player2.wantsToPlayAgain();
    }
}

