package bank.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "saving_accounts")
@PrimaryKeyJoinColumn(name = "account_id")
public class SavingAccount extends AbstractAccount {

    @Column(name = "interest_rate")
    private double interestRate;

    public SavingAccount() {
    }

    public SavingAccount(String accountNumber, double balance, User user, double interestRate) {
        super(accountNumber, balance, user);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void addInterest() {
        super.setBalance(super.getBalance() + (super.getBalance() * this.interestRate));
    }
}