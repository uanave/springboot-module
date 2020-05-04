package academy.everyonecodes.rides.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class Driver {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;
    private String carType;

    @OneToMany
    private Set<Ride> rides = new HashSet<>();

    public Driver() {
    }

    public Driver(String username, String carType) {
        this.username = username;
        this.carType = carType;
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

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Set<Ride> getRides() {
        return rides;
    }

    public void setRides(Set<Ride> rides) {
        this.rides = rides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(id, driver.id) &&
                Objects.equals(username, driver.username) &&
                Objects.equals(carType, driver.carType) &&
                Objects.equals(rides, driver.rides);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, carType, rides);
    }
}
