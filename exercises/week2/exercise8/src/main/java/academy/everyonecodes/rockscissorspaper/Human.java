package academy.everyonecodes.rockscissorspaper;

import java.util.Optional;
import java.util.Scanner;

public class Human implements Player {
    private final MoveUtils moveUtils;
    private final Scanner scanner = new Scanner(System.in);

    public Human(MoveUtils moveUtils) {
        this.moveUtils = moveUtils;
    }

    @Override
    public Move play() {
        Optional<Move> oMove = Optional.empty();
        while (oMove.isEmpty()) {
            System.out.println("Enter your move from this list: " + moveUtils.getNames());
            oMove = moveUtils.getOne(scanner.nextLine());
        }
        return oMove.get();
    }

    @Override
    public boolean wantsToPlayAgain() {
        System.out.println("Do you want to play again? Y/N");
        return scanner.nextLine().equalsIgnoreCase("Y");
    }
}
