package vehicles.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "passengers")
@PrimaryKeyJoinColumn(name = "carriage_id")
public class Passenger extends Carriage {

    @Column(name = "standing_count")
    private int standingCount;

    public Passenger() {
    }

    public Passenger(int passengersSeats, Train train, int standingCount) {
        super(passengersSeats, train);
        this.standingCount = standingCount;
    }

    public int getStandingCount() {
        return this.standingCount;
    }

    public void setStandingCount(int standingCount) {
        this.standingCount = standingCount;
    }
}