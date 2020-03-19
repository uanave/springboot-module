package academy.everyonecodes.rockscissorspaper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfiguration {

    @Bean
    Player player1(MoveUtils moveUtils) {
        return new Human(moveUtils);
    }

    @Bean
    Player player2(List<Move> moves) {
        return new Computer(moves);
    }
}
