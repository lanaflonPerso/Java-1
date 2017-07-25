package hotel.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long id;

    @Column(name = "customer_first_name", length = 50)
    private String firstName;

    @Column(name = "customer_last_name", length = 50)
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "emergency_name")
    private String emergencyName;

    @Column(name = "emergency_number")
    private String emergencyNumber;

    @Basic
    private String notes;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String phoneNumber, String emergencyName, String emergencyNumber, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emergencyName = emergencyName;
        this.emergencyNumber = emergencyNumber;
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

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmergencyName() {
        return this.emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public String getEmergencyNumber() {
        return this.emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}