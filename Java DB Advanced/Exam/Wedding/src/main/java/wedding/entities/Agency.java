package wedding.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "agencies")
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agency_id")
    private long id;

    @Basic
    private String name;

    @Column(name = "employees_count")
    private int employeesCount;

    @Basic
    private String town;

    @OneToMany(mappedBy = "agency")
    private Set<Wedding> weddings;

    public Agency() {
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

    public int getEmployeesCount() {
        return this.employeesCount;
    }

    public void setEmployeesCount(int employeesCount) {
        this.employeesCount = employeesCount;
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
