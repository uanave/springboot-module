package academy.everyonecodes.rides.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Ride {

    @Id
    @GeneratedValue
    private Long id;

    private String customer;
    private String distance;
    private double price;

    public Ride() {
    }

    public Ride(String customer, String distance, double price) {
        this.customer = customer;
        this.distance = distance;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return Double.compare(ride.price, price) == 0 &&
                Objects.equals(id, ride.id) &&
                Objects.equals(customer, ride.customer) &&
                Objects.equals(distance, ride.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, distance, price);
    }
}
