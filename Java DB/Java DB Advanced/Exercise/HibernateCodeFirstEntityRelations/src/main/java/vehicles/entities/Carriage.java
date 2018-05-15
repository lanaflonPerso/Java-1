package vehicles.entities;

import vehicles.entities.Train;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "carriages")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Carriage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carriage_id")
    private long id;

    @Column(name = "passengers_seats")
    private int passengersSeats;

    @ManyToOne(optional = false)
    @JoinColumn(name = "train_id")
    private Train train;

    protected Carriage() {
    }

    protected Carriage(int passengersSeats, Train train) {
        this.passengersSeats = passengersSeats;
        this.train = train;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPassengersSeats() {
        return this.passengersSeats;
    }

    public void setPassengersSeats(int passengersSeats) {
        this.passengersSeats = passengersSeats;
    }

    public Train getTrain() {
        return this.train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}