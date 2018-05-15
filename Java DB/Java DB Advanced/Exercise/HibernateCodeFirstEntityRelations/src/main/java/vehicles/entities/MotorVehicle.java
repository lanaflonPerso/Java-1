package vehicles.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "motor_vehicles")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public abstract class MotorVehicle extends Vehicle {

    @Column(name = "number_of_engines")
    private int numberOfEngines;

    @Column(name = "engine_type")
    private String engineType;

    @Column(name = "tank_capacity")
    private double tankCapacity;

    protected MotorVehicle() {
    }

    protected MotorVehicle(String manufacturer, double price, double maxSpeed, int numberOfEngines, String engineType, double tankCapacity) {
        super(manufacturer, price, maxSpeed);
        this.numberOfEngines = numberOfEngines;
        this.engineType = engineType;
        this.tankCapacity = tankCapacity;
    }

    public int getNumberOfEngines() {
        return this.numberOfEngines;
    }

    public void setNumberOfEngines(int numberOfEngines) {
        this.numberOfEngines = numberOfEngines;
    }

    public String getEngineType() {
        return this.engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    @Override
    public String toString() {
        return "MotorVehicle{" +
                "numberOfEngines=" + numberOfEngines +
                ", engineType='" + engineType + '\'' +
                ", tankCapacity=" + tankCapacity +
                '}';
    }
}
