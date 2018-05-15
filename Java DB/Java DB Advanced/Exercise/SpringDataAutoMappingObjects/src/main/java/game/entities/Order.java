package game.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 30/07/2017.
 */

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "orders_games",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"),
            foreignKey = @ForeignKey(name = "fk_orders_games_orders"),
            inverseForeignKey = @ForeignKey(name = "fk_order_games_games"))
    private Set<Game> games;

    public Order() {
    }

    public long getId() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    public Set<Game> getGames() {
        return this.games;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public String toString() {
        return "game.entities.Order(id=" + this.getId() + ", user=" + this.getUser() + ", games=" + this.getGames() + ")";
    }
}
