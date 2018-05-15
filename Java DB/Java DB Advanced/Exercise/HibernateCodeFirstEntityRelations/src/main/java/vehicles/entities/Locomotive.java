package vehicles.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "locomotives")
public class Locomotive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locomotive_id")
    private long id;

    @Basic
    private String model;

    @Basic
    private double power;

    @OneToOne(optional = false)
    @JoinColumn(name = "train_id")
    private Train train;

    public Locomotive() {
    }

    public Locomotive(String model, double power, Train train) {
        this.model = model;
        this.power = power;
        this.train = train;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPower() {
        return this.power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public Train getTrain() {
        return this.train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
