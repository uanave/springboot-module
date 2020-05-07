package academy.everyonecodes.steampurchases.persistence.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Purchase {
    @NotEmpty
    private String username;
    @NotEmpty
    private String gameName;
    @NotEmpty
    private String gameId;
    @NotNull
    private double gamePrice;

    public Purchase(@NotEmpty String username,
                    @NotEmpty String gameName,
                    @NotEmpty String gameId,
                    @NotNull double gamePrice) {
        this.username = username;
        this.gameName = gameName;
        this.gameId = gameId;
        this.gamePrice = gamePrice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public double getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(double gamePrice) {
        this.gamePrice = gamePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Double.compare(purchase.gamePrice, gamePrice) == 0 &&
                Objects.equals(username, purchase.username) &&
                Objects.equals(gameName, purchase.gameName) &&
                Objects.equals(gameId, purchase.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, gameName, gameId, gamePrice);
    }
}
