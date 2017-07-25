package vehicles.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "restaurants")
@PrimaryKeyJoinColumn(name = "carriage_id")
public class Restaurant extends Carriage {

    @Column(name = "tables_count")
    private int tablesCount;

    public Restaurant() {
    }

    public Restaurant(int passengersSeats, Train train, int tablesCount) {
        super(passengersSeats, train);
        this.tablesCount = tablesCount;
    }

    public int getTablesCount() {
        return this.tablesCount;
    }

    public void setTablesCount(int tablesCount) {
        this.tablesCount = tablesCount;
    }
}