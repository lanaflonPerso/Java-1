package vehicles.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "sleepings")
@PrimaryKeyJoinColumn(name = "carriage_id")
public class Sleeping extends Carriage {

    @Column(name = "beds_count")
    private int bedsCount;

    public Sleeping() {
    }

    public Sleeping(int passengersSeats, Train train, int bedsCount) {
        super(passengersSeats, train);
        this.bedsCount = bedsCount;
    }

    public int getBedsCount() {
        return this.bedsCount;
    }

    public void setBedsCount(int bedsCount) {
        this.bedsCount = bedsCount;
    }
}