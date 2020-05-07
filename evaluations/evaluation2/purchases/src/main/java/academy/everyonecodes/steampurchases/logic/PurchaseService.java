package academy.everyonecodes.steampurchases.logic;

import academy.everyonecodes.steampurchases.persistence.domain.Game;
import academy.everyonecodes.steampurchases.persistence.domain.Purchase;
import academy.everyonecodes.steampurchases.persistence.domain.User;
import academy.everyonecodes.steampurchases.persistence.repository.GameRepository;
import academy.everyonecodes.steampurchases.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    public PurchaseService(UserRepository userRepository, GameRepository gameRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    public Purchase save(Purchase purchase) {
        Game game = extractGame(purchase);
        User user = extractUser(purchase);
        addGameToUser(game, user);
        return purchase;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public List<Game> findAllGames() {
        return gameRepository.findAll();
    }

    public Game extractGame(Purchase purchase) {
        Game game = new Game(purchase.getGameId(),
                purchase.getGameName(),
                purchase.getGamePrice());
        Optional<Game> oGame = gameRepository.findOneByIdentifier(game.getIdentifier());
        if (oGame.isEmpty()) {
            gameRepository.save(game);
            return game;
        }
        return oGame.get();
    }

    public User extractUser(Purchase purchase) {
        User user = new User(purchase.getUsername());
        Optional<User> oUser = userRepository.findOneByUsername(user.getUsername());
        if (oUser.isEmpty()) {
            userRepository.save(user);
            return user;
        }
        return oUser.get();
    }

    public void addGameToUser(Game game, User user) {
        user.getGames().add(game);
        userRepository.save(user);
    }
}
