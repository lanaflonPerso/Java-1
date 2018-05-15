package hotel.entities;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */
@Entity
@Table(name = "occupancies")
public class Occupancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "occupancy_id")
    private long id;

    @Column(name = "date_occupied")
    private LocalDate dateOccupied;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "rate_applied")
    private double rateApplied;

    @Column(name = "phone_charge")
    private String phoneCharge;

    @Basic
    private String notes;

    public Occupancy() {
    }

    public Occupancy(LocalDate dateOccupied, String accountNumber, String roomNumber, double rateApplied, String phoneCharge, String notes) {
        this.dateOccupied = dateOccupied;
        this.accountNumber = accountNumber;
        this.roomNumber = roomNumber;
        this.rateApplied = rateApplied;
        this.phoneCharge = phoneCharge;
        this.notes = notes;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateOccupied() {
        return this.dateOccupied;
    }

    public void setDateOccupied(LocalDate dateOccupied) {
        this.dateOccupied = dateOccupied;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getRateApplied() {
        return this.rateApplied;
    }

    public void setRateApplied(double rateApplied) {
        this.rateApplied = rateApplied;
    }

    public String getPhoneCharge() {
        return this.phoneCharge;
    }

    public void setPhoneCharge(String phoneCharge) {
        this.phoneCharge = phoneCharge;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
