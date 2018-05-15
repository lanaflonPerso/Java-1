package hotel.entities;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private long id;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "first_date_occupied")
    private LocalDate firstDateOccupied;

    @Column(name = "last_date_occupied")
    private LocalDate lastDateOccupied;

    @Column(name = "total_days")
    private int totalDays;

    @Column(name = "amount_charged")
    private double amountCharged;

    @Column(name = "tax_rate")
    private double taxRate;

    @Column(name = "tax_amount")
    private double taxAmount;

    @Column(name = "payment_total")
    private double paymentTotal;

    @Basic
    private String notes;

    public Payment() {
    }

    public Payment(LocalDate paymentDate, String accountNumber, LocalDate firstDateOccupied, LocalDate lastDateOccupied, int totalDays, double amountCharged, double taxRate, double taxAmount, double paymentTotal, String notes) {
        this.paymentDate = paymentDate;
        this.accountNumber = accountNumber;
        this.firstDateOccupied = firstDateOccupied;
        this.lastDateOccupied = lastDateOccupied;
        this.totalDays = totalDays;
        this.amountCharged = amountCharged;
        this.taxRate = taxRate;
        this.taxAmount = taxAmount;
        this.paymentTotal = paymentTotal;
        this.notes = notes;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDate getFirstDateOccupied() {
        return this.firstDateOccupied;
    }

    public void setFirstDateOccupied(LocalDate firstDateOccupied) {
        this.firstDateOccupied = firstDateOccupied;
    }

    public LocalDate getLastDateOccupied() {
        return this.lastDateOccupied;
    }

    public void setLastDateOccupied(LocalDate lastDateOccupied) {
        this.lastDateOccupied = lastDateOccupied;
    }

    public int getTotalDays() {
        return this.totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public double getAmountCharged() {
        return this.amountCharged;
    }

    public void setAmountCharged(double amountCharged) {
        this.amountCharged = amountCharged;
    }

    public double getTaxRate() {
        return this.taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getTaxAmount() {
        return this.taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getPaymentTotal() {
        return this.paymentTotal;
    }

    public void setPaymentTotal(double paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
