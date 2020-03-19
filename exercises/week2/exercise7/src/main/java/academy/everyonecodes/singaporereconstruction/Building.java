package academy.everyonecodes.singaporereconstruction;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class Building {
    private String name;
    private LocalDate built;
    private boolean historic;

    Building() {
    }

    public Building(String name, LocalDate built, boolean historic) {
        this.name = name;
        this.built = built;
        this.historic = historic;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public LocalDate getBuilt() {
        return built;
    }

    void setBuilt(LocalDate built) {
        this.built = built;
    }

    public boolean isHistoric() {
        return historic;
    }

    void setHistoric(boolean historic) {
        this.historic = historic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return historic == building.historic &&
                Objects.equals(name, building.name) &&
                Objects.equals(built, building.built);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, built, historic);
    }
}
