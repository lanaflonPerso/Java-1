package vehicles.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "planes")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Plane extends MotorVehicle {

    @Column(name = "airline_owner")
    private String airlineOwner;

    @Basic
    private String color;

    @Column(name = "passengers_capacity")
    private int passengersCapacity;

    public Plane() {
    }

    public Plane(String manufacturer, double price, double maxSpeed, int numberOfEngines, String engineType, double tankCapacity, String airlineOwner, String color, int passengersCapacity) {
        super(manufacturer, price, maxSpeed, numberOfEngines, engineType, tankCapacity);
        this.airlineOwner = airlineOwner;
        this.color = color;
        this.passengersCapacity = passengersCapacity;
    }

    public String getAirlineOwner() {
        return this.airlineOwner;
    }

    public void setAirlineOwner(String airlineOwner) {
        this.airlineOwner = airlineOwner;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPassengersCapacity() {
        return this.passengersCapacity;
    }

    public void setPassengersCapacity(int passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }
}