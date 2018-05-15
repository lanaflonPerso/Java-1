package hotel.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */

@Entity
@Table(name = "bed_types")
public class BedType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bed_type_id")
    private long id;

    @Column(name = "bed_type")
    private String bedType;

    @Basic
    private String notes;

    public BedType() {
    }

    public BedType(String bedType, String notes) {
        this.bedType = bedType;
        this.notes = notes;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBedType() {
        return this.bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}