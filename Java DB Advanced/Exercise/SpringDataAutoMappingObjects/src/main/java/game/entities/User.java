package game.entities;

import game.annotations.Email;
import game.annotations.Password;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 28/07/2017.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(unique = true)
    @Email
    private String email;

    @Basic
    @Password
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @ManyToMany
    @JoinTable(name = "users_games",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "game_id"),
    foreignKey = @ForeignKey(name = "fk_users_games_users"),
    inverseForeignKey = @ForeignKey(name = "fk_users_games_games"))
    private Set<Game> games;

    @Column(name = "is_admin")
    private boolean admin;

    @Column(name = "is_logged_in")
    private boolean loggedIn;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = false)
    private Order order;

    public User() {
        this.admin = false;
        this.loggedIn = false;
    }

    public long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFullName() {
        return this.fullName;
    }

    public Set<Game> getGames() {
        return this.games;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String toString() {
        return "game.entities.User(id=" + this.getId() + ", email=" + this.getEmail() + ", password=" + this.getPassword() + ", fullName=" + this.getFullName() + ", isAdmin=" + this.isAdmin() + ")";
    }
}
