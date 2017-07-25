package vehicles.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "ships")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public abstract class Ship extends MotorVehicle {

    @Basic
    private String nationality;

    @Column(name = "captain_name")
    private String captainName;

    @Column(name = "size_of_ship_crew")
    private int sizeOfShipCrew;

    public Ship() {
    }

    public Ship(String manufacturer, double price, double maxSpeed, int numberOfEngines, String engineType, double tankCapacity, String nationality, String captainName, int sizeOfShipCrew) {
        super(manufacturer, price, maxSpeed, numberOfEngines, engineType, tankCapacity);
        this.nationality = nationality;
        this.captainName = captainName;
        this.sizeOfShipCrew = sizeOfShipCrew;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCaptainName() {
        return this.captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public int getSizeOfShipCrew() {
        return this.sizeOfShipCrew;
    }

    public void setSizeOfShipCrew(int sizeOfShipCrew) {
        this.sizeOfShipCrew = sizeOfShipCrew;
    }
}