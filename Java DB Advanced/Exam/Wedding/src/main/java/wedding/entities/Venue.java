package wedding.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "venues")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venue_id")
    private long id;

    @Basic
    private String name;

    @Basic
    private int capacity;

    @Basic
    private String town;

    @ManyToMany(mappedBy = "venues", fetch = FetchType.EAGER)
    private Set<Wedding> weddings;

    public Venue() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Set<Wedding> getWeddings() {
        return this.weddings;
    }

    public void setWeddings(Set<Wedding> weddings) {
        this.weddings = weddings;
    }
}
