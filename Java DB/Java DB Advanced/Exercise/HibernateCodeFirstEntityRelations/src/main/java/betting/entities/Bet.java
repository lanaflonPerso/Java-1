package betting.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

@Entity
@Table(name = "bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bet_id")
    private long id;

    @Column(name = "bet_money")
    private double betMoney;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_bets_users"))
    private User user;

    public Bet() {
    }

    public Bet(double betMoney, LocalDateTime dateTime, User user) {
        this.betMoney = betMoney;
        this.dateTime = dateTime;
        this.user = user;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBetMoney() {
        return this.betMoney;
    }

    public void setBetMoney(double betMoney) {
        this.betMoney = betMoney;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
