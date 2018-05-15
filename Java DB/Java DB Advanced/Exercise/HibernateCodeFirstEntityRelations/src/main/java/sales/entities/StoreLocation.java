package sales.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */

@Entity
@Table(name = "store_locations")
public class StoreLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_location_id")
    private long id;

    @Column(name = "location_name", length = 50)
    private String locationName;

    @OneToMany(mappedBy = "storeLocation")
    private Set<Sale> sales;

    public StoreLocation() {
    }

    public StoreLocation(String locationName) {
        this.locationName = locationName;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Set<Sale> getSales() {
        return this.sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}