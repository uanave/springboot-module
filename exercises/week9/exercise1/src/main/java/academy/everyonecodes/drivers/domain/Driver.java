package academy.everyonecodes.drivers.domain;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Driver {
    private String id;

    @Indexed(unique = true)
    private String username;
    private String password;
    private String carType;
    private Set<String> authorities = new HashSet<>();
    private boolean isAvailable;

    public Driver() {
    }

    public Driver(String username, String password, String carType) {
        this.username = username;
        this.password = password;
        this.carType = carType;
    }

    public Driver(String username, String password, String carType, Set<String> authorities, boolean isAvailable) {
        this.username = username;
        this.password = password;
        this.carType = carType;
        this.authorities = authorities;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return isAvailable == driver.isAvailable &&
                Objects.equals(id, driver.id) &&
                Objects.equals(username, driver.username) &&
                Objects.equals(password, driver.password) &&
                Objects.equals(carType, driver.carType) &&
                Objects.equals(authorities, driver.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, carType, authorities, isAvailable);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", carType='" + carType + '\'' +
                ", authorities=" + authorities +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
