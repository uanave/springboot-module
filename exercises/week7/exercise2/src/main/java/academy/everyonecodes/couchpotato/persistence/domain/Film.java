package academy.everyonecodes.couchpotato.persistence.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
public class Film {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String name;

    @Min(1)
    @Max(5)
    private int rating;

    public Film(@NotBlank @NotEmpty String name, @Min(1) @Max(5) int rating) {
        this.name = name;
        this.rating = rating;
    }

    public Film() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return rating == film.rating &&
                Objects.equals(id, film.id) &&
                Objects.equals(name, film.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rating);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
