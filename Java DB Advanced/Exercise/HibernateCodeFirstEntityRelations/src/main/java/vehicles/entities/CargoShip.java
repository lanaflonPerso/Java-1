package vehicles.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "cargo_ships")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class CargoShip extends Ship {

    @Column(name = "max_load_kilograms")
    private double maxLoadKilograms;

    public CargoShip() {
    }

    public CargoShip(String manufacturer, double price, double maxSpeed, int numberOfEngines, String engineType, double tankCapacity, String nationality, String captainName, int sizeOfShipCrew, double maxLoadKilograms) {
        super(manufacturer, price, maxSpeed, numberOfEngines, engineType, tankCapacity, nationality, captainName, sizeOfShipCrew);
        this.maxLoadKilograms = maxLoadKilograms;
    }

    public double getMaxLoadKilograms() {
        return this.maxLoadKilograms;
    }

    public void setMaxLoadKilograms(double maxLoadKilograms) {
        this.maxLoadKilograms = maxLoadKilograms;
    }

    @Override
    public String toString() {
        return "CargoShip{" +
                "maxLoadKilograms=" + maxLoadKilograms +
                '}';
    }
}