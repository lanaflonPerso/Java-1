package bank.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "accounts")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Basic
    private double balance;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    protected AbstractAccount() {
    }

    protected AbstractAccount(String accountNumber, double balance, User user) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.user = user;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean deposit(double money) {
        if (money < 0) {
            return false;
        }
        this.balance += money;
        return true;
    }

    public boolean withdraw(double money) {
        if (money < 0 || this.balance - money < 0) {
            return false;
        }
        this.balance -= money;
        return true;
    }

    @Override
    public String toString() {
        return String.format("--%s %.2f", this.getAccountNumber(), this.getBalance());
    }
}