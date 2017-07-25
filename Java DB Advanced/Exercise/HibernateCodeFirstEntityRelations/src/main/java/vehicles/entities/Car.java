package vehicles.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "cars")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Car extends MotorVehicle {

    @Column(name = "number_of_doors")
    private int numberOfDoors;

    @Column(name = "has_insurance")
    private boolean hasInsurance;

    public Car() {
    }

    public Car(String manufacturer, double price, double maxSpeed, int numberOfEngines, String engineType, double tankCapacity, int numberOfDoors, boolean hasInsurance) {
        super(manufacturer, price, maxSpeed, numberOfEngines, engineType, tankCapacity);
        this.numberOfDoors = numberOfDoors;
        this.hasInsurance = hasInsurance;
    }

    public int getNumberOfDoors() {
        return this.numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public boolean isHasInsurance() {
        return this.hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }
}