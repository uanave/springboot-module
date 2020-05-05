package academy.everyonecodes.validation.domain;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Validated
public class Artwork {
    @NotEmpty
    private String name;
    @Valid
    private Rating rating;

    public Artwork(@NotEmpty String name, @Valid Rating rating) {
        this.name = name;
        this.rating = rating;
    }

    public Artwork() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
