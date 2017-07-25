package hotel.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long id;

    @Column(name = "employee_first_name", length = 50)
    private String firstName;

    @Column(name = "employee_last_name", length = 50)
    private String lastName;

    @Basic
    private String title;

    @Basic
    private String notes;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String title, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.notes = notes;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}