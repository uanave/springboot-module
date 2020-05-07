package academy.everyonecodes.steampurchases.persistence.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    @NotNull
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Game> games = new HashSet<>();

    public User() {
    }

    public User(@NotNull String username, Set<Game> games) {
        this.username = username;
        this.games = games;
    }

    public User(@NotNull String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(games, user.games);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, games);
    }
}
