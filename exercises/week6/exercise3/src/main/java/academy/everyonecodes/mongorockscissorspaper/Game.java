package academy.everyonecodes.mongorockscissorspaper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Game {
    private Player player1;
    private Player player2;
    private Judge judge;
    private GameResultManager gameResultManager;
    private String resultPlayer1;
    private String resultPlayer2;
    private String resultTie;

    public Game(Player player1, Player player2, Judge judge, GameResultManager gameResultManager,
                @Value("${results.player1}") String resultPlayer1,
                @Value("${results.player2}") String resultPlayer2,
                @Value("${results.tie}") String resultTie) {
        this.player1 = player1;
        this.player2 = player2;
        this.judge = judge;
        this.gameResultManager = gameResultManager;
        this.resultPlayer1 = resultPlayer1;
        this.resultPlayer2 = resultPlayer2;
        this.resultTie = resultTie;
    }

    public void play() {
        System.out.println("Welcome to the game!");
        boolean wantToPlay = true;
        while (wantToPlay) {
            playOneRound(player1, player2);
            wantToPlay = askToPlayAgain(player1, player2);
        }
        gameResultManager.deleteAll();
        System.out.println("Goodbye");
    }

    private void playOneRound(Player player1, Player player2) {
        System.out.println(createStatistic());
        Move move1 = player1.play();
        Move move2 = player2.play();
        System.out.println("Player 1 chose: " + move1.getName());
        System.out.println("Player 2 chose: " + move2.getName());
        String result = judge.judge(move1, move2);
        gameResultManager.saveResult(result);
        System.out.println(result);
    }

    private String createStatistic() {
        String statistics = "Game statistics:";
        long player1Wins = gameResultManager.countResult(resultPlayer1);
        long player2Wins = gameResultManager.countResult(resultPlayer2);
        long tie = gameResultManager.countResult(resultTie);
        List<String> results = new ArrayList<>();
        if (player1Wins != 0) {
            results.add("Player 1 wins: " + player1Wins);
        }
        if (player2Wins != 0) {
            results.add("Player 2 wins: " + player2Wins);
        }
        if (tie != 0) {
            results.add("Ties: " + tie);
        }
        return statistics + " " + String.join(", ", results);
    }

    private boolean askToPlayAgain(Player player1, Player player2) {
        return player1.wantsToPlayAgain() && player2.wantsToPlayAgain();
    }
}

