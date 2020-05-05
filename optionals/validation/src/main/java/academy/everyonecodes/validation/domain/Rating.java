package academy.everyonecodes.validation.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Rating {

    @Min(1)
    @Max(5)
    private int stars;

    public Rating(@Min(1) @Max(5) int stars) {
        this.stars = stars;
    }

    public Rating() {
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
