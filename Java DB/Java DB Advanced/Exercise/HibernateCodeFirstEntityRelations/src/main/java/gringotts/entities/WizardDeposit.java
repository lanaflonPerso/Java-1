package gringotts.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */
@Entity
@Table(name = "wizard_deposits")
public class WizardDeposit {
    private static final String AGE_CANNOT_BE_NEGATIVE = "Age cannot be negative!";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wizard_deposit_id")
    private int id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 60, nullable = false)
    private String lastName;

    @Column(length = 1000)
    private String notes;

    @Column(nullable = false)
    private int age;

    @Column(name = "magic_wand_creator", length = 100)
    private String magicWandCreator;

    @Column(name = "magic_wand_size")
    private short magicWandSize;

    @Column(name = "deposit_group", length = 20)
    private String depositGroup;

    @Column(name = "deposit_start_date")
    private LocalDateTime depositStartDate;

    @Column(name = "deposit_amount")
    private double depositAmount;

    @Column(name = "deposit_interest")
    private double depositInterest;

    @Column(name = "deposit_charge")
    private double depositCharge;

    @Column(name = "deposit_expiration_date")
    private LocalDateTime depositExpirationDate;

    @Column(name = "is_deposit_expired")
    private boolean isDepositExpired;

    public WizardDeposit() {
    }

    public WizardDeposit(String firstName, String lastName, String notes, int age, String magicWandCreator, short magicWandSize, String depositGroup, LocalDateTime depositStartDate, double depositAmount, double depositInterest, double depositCharge, LocalDateTime depositExpirationDate, boolean isDepositExpired) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.notes = notes;
        this.age = age;
        this.magicWandCreator = magicWandCreator;
        this.magicWandSize = magicWandSize;
        this.depositGroup = depositGroup;
        this.depositStartDate = depositStartDate;
        this.depositAmount = depositAmount;
        this.depositInterest = depositInterest;
        this.depositCharge = depositCharge;
        this.depositExpirationDate = depositExpirationDate;
        this.isDepositExpired = isDepositExpired;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
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

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(AGE_CANNOT_BE_NEGATIVE);
        }
        this.age = age;
    }

    public String getMagicWandCreator() {
        return this.magicWandCreator;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
    }

    public short getMagicWandSize() {
        return this.magicWandSize;
    }

    public void setMagicWandSize(short magicWandSize) {
        this.magicWandSize = magicWandSize;
    }

    public String getDepositGroup() {
        return this.depositGroup;
    }

    public void setDepositGroup(String depositGroup) {
        this.depositGroup = depositGroup;
    }

    public LocalDateTime getDepositStartDate() {
        return this.depositStartDate;
    }

    public void setDepositStartDate(LocalDateTime depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    public double getDepositAmount() {
        return this.depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getDepositInterest() {
        return this.depositInterest;
    }

    public void setDepositInterest(double depositInterest) {
        this.depositInterest = depositInterest;
    }

    public double getDepositCharge() {
        return this.depositCharge;
    }

    public void setDepositCharge(double depositCharge) {
        this.depositCharge = depositCharge;
    }

    public LocalDateTime getDepositExpirationDate() {
        return this.depositExpirationDate;
    }

    public void setDepositExpirationDate(LocalDateTime depositExpirationDate) {
        this.depositExpirationDate = depositExpirationDate;
    }

    public boolean isDepositExpired() {
        return this.isDepositExpired;
    }

    public void setDepositExpired(boolean depositExpired) {
        isDepositExpired = depositExpired;
    }

    @Override
    public String toString() {
        return "WizardDeposit{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", notes='" + notes + '\'' +
                ", age=" + age +
                ", magicWandCreator='" + magicWandCreator + '\'' +
                ", magicWandSize=" + magicWandSize +
                ", depositGroup='" + depositGroup + '\'' +
                ", depositStartDate=" + depositStartDate +
                ", depositAmount=" + depositAmount +
                ", depositInterest=" + depositInterest +
                ", depositCharge=" + depositCharge +
                ", depositExpirationDate=" + depositExpirationDate +
                ", isDepositExpired=" + isDepositExpired +
                '}';
    }
}
