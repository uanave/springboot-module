package academy.everyonecodes.secretagenthandshakes;

import java.util.Objects;

public class Handshake {
    private int number;
    private String move;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Handshake handshake = (Handshake) o;
        return number == handshake.number &&
                Objects.equals(move, handshake.move);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, move);
    }
}
