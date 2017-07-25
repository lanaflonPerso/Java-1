package vehicles.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "trains")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Train extends MotorVehicle {

    @Column(name = "number_of_doors")
    private int numberOfDoors;

    @Column(name = "has_insurance")
    private boolean hasInsurance;

    @OneToOne(mappedBy = "train", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Locomotive locomotive;

    @Column(name = "number_of_carriages")
    private int numberOfCarriages;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Carriage> carriages;

    public Train() {
    }

    public Train(String manufacturer, double price, double maxSpeed, int numberOfEngines, String engineType, double tankCapacity, int numberOfDoors, boolean hasInsurance, Locomotive locomotive, int numberOfCarriages, List<Carriage> carriages) {
        super(manufacturer, price, maxSpeed, numberOfEngines, engineType, tankCapacity);
        this.numberOfDoors = numberOfDoors;
        this.hasInsurance = hasInsurance;
        this.locomotive = locomotive;
        this.numberOfCarriages = numberOfCarriages;
        this.carriages = carriages;
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

    public Locomotive getLocomotive() {
        return this.locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public int getNumberOfCarriages() {
        return this.numberOfCarriages;
    }

    public void setNumberOfCarriages(int numberOfCarriages) {
        this.numberOfCarriages = numberOfCarriages;
    }

    public List<Carriage> getCarriages() {
        return this.carriages;
    }

    public void setCarriages(List<Carriage> carriages) {
        this.carriages = carriages;
    }
}