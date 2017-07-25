package vehicles.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "bikes")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Bike extends NonMotorVehicle {

    @Basic
    private int shiftsCount;

    @Basic
    private String color;

    public Bike() {
    }

    public Bike(String manufacturer, double price, double maxSpeed, int shiftsCount, String color) {
        super(manufacturer, price, maxSpeed);
        this.shiftsCount = shiftsCount;
        this.color = color;
    }

    public int getShiftsCount() {
        return this.shiftsCount;
    }

    public void setShiftsCount(int shiftsCount) {
        this.shiftsCount = shiftsCount;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
