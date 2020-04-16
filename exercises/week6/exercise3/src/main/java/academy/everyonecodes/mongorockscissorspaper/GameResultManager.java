package academy.everyonecodes.mongorockscissorspaper;

import org.springframework.stereotype.Service;

@Service
public class GameResultManager {
    private GameResultRepository gameResultRepository;

    public GameResultManager(GameResultRepository gameResultRepository) {
        this.gameResultRepository = gameResultRepository;
    }

    long countResult(String result) {
        return gameResultRepository.countByResult(result);
    }

    void saveResult(String result) {
        GameResult gameResult = new GameResult(result);
        gameResultRepository.save(gameResult);
    }
}
