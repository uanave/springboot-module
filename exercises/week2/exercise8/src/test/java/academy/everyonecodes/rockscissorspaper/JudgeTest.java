package academy.everyonecodes.rockscissorspaper;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JudgeTest {
    Judge judge = new Judge();

    @ParameterizedTest
    @MethodSource("parameters")
    void judge(String expected, Move move1, Move move2) {
        String result = judge.judge(move1, move2);

        assertEquals(expected, result);
    }
    static Stream<Arguments> parameters(){
        return Stream.of(
                Arguments.of("You won!", new Move("rock", "scissor"), new Move("scissor", "paper")),
                Arguments.of("You lost!", new Move("paper", "rock"), new Move("scissor", "paper")),
                Arguments.of("It's a tie!", new Move("rock", "scissor"),new Move("rock", "scissor")
                )
        );
    }
}