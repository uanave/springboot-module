package academy.everyonecodes.mysteriouscalculator;

public class MysteriousAddition {
    private final int number;

    public MysteriousAddition(int number) {
        this.number = number;
    }

    public int apply(int input) {
        return input + number;
    }
}
