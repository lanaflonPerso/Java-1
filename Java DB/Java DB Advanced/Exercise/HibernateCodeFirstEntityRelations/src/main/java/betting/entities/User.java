package betting.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Basic
    private String username;

    @Basic
    private String password;

    @Basic
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @Basic
    private double balance;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Bet> bets;


    public User() {
    }

    public User(String username, String password, String email, String fullName, double balance, Set<Bet> bets) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.balance = balance;
        this.bets = bets;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Set<Bet> getBets() {
        return this.bets;
    }

    public void setBets(Set<Bet> bets) {
        this.bets = bets;
    }
}
