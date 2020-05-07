package academy.everyonecodes.steampurchases.logic;

import academy.everyonecodes.steampurchases.persistence.domain.Game;
import academy.everyonecodes.steampurchases.persistence.domain.Purchase;
import academy.everyonecodes.steampurchases.persistence.domain.User;
import academy.everyonecodes.steampurchases.persistence.repository.GameRepository;
import academy.everyonecodes.steampurchases.persistence.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class PurchaseServiceTest {

    @Autowired
    PurchaseService purchaseService;

    @MockBean
    UserRepository userRepository;

    @MockBean
    GameRepository gameRepository;

    Purchase purchase = new Purchase("username", "Mario Cart", "ID", 25.5);
    Game game = new Game(purchase.getGameId(),
            purchase.getGameName(),
            purchase.getGamePrice());
    User user = new User(purchase.getUsername());

    @Test
    void findAllUsers() {
        purchaseService.findAllUsers();

        verify(userRepository).findAll();
    }

    @Test
    void findAllGames() {
        purchaseService.findAllGames();

        verify(gameRepository).findAll();
    }

    @Test
    void findsNonExistingGame() {

        when(gameRepository.findOneByIdentifier(game.getIdentifier()))
                .thenReturn(Optional.empty());

        purchaseService.extractGame(purchase);

        verify(gameRepository).findOneByIdentifier(game.getIdentifier());
        verify(gameRepository).save(game);
    }


    @Test
    void findsExistingGame() {

        when(gameRepository.findOneByIdentifier(game.getIdentifier()))
                .thenReturn(Optional.of(game));

        purchaseService.extractGame(purchase);

        verify(gameRepository).findOneByIdentifier(game.getIdentifier());
        verifyNoMoreInteractions(gameRepository);
        verifyNoInteractions(userRepository);
    }

    @Test
    void findsNonExistingUser() {
        when(userRepository.findOneByUsername(user.getUsername()))
                .thenReturn(Optional.empty());

        purchaseService.extractUser(purchase);

        User expected = new User(purchase.getUsername());

        verify(userRepository).findOneByUsername(user.getUsername());
        verify(userRepository).save(expected);
    }

    @Test
    void findsExistingUser() {
        when(userRepository.findOneByUsername(user.getUsername()))
                .thenReturn(Optional.of(user));

        purchaseService.extractUser(purchase);

        verify(userRepository).findOneByUsername(user.getUsername());
        verifyNoMoreInteractions(userRepository);
        verifyNoInteractions(gameRepository);
    }

    @Test
    void addGameToUser() {
        purchaseService.addGameToUser(game, user);
        assertTrue(user.getGames().contains(game));
        verify(userRepository).save(user);
    }
}