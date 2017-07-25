package vehicles.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private long id;

    @Basic
    private String manufacturer;

    @Basic
    private double price;

    @Column(name = "max_speed")
    private double maxSpeed;

    protected Vehicle() {
    }

    protected Vehicle(String manufacturer, double price, double maxSpeed) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.maxSpeed = maxSpeed;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMaxSpeed() {
        return this.maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
