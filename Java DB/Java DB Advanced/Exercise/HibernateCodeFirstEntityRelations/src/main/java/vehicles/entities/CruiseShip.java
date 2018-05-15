package vehicles.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "cruise_ships")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class CruiseShip extends Ship {

    @Column(name = "passengers_capacity")
    private double passengersCapacity;

    public CruiseShip() {
    }

    public CruiseShip(String manufacturer, double price, double maxSpeed, int numberOfEngines, String engineType, double tankCapacity, String nationality, String captainName, int sizeOfShipCrew, double passengersCapacity) {
        super(manufacturer, price, maxSpeed, numberOfEngines, engineType, tankCapacity, nationality, captainName, sizeOfShipCrew);
        this.passengersCapacity = passengersCapacity;
    }

    public double getPassengersCapacity() {
        return this.passengersCapacity;
    }

    public void setPassengersCapacity(double passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }
}