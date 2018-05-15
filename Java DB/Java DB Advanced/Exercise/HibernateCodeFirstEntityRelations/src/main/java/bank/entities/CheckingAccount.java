package bank.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "checking_accounts")
@PrimaryKeyJoinColumn(name = "account_id")
public class CheckingAccount extends AbstractAccount {

    @Basic
    private double fee;

    public CheckingAccount() {
    }

    public CheckingAccount(String accountNumber, double balance, User user, double fee) {
        super(accountNumber, balance, user);
        this.fee = fee;
    }

    public double getFee() {
        return this.fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void deductFee() {
        this.setBalance(this.getBalance() - this.fee);
    }
}