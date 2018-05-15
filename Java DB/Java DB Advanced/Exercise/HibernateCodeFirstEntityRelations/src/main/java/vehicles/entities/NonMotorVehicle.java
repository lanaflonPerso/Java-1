package vehicles.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "non_motor_vehicles")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public abstract class NonMotorVehicle extends Vehicle {
    protected NonMotorVehicle() {
    }

    protected NonMotorVehicle(String manufacturer, double price, double maxSpeed) {
        super(manufacturer, price, maxSpeed);
    }
}
