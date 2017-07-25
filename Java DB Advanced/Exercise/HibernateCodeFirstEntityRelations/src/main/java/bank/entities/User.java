package bank.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 23/07/2017.
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

    @Column(name = "is_logged_in")
    private boolean isLoggedIn;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<AbstractAccount> accounts;

    public User() {
        isLoggedIn = false;
    }

    public User(String username, String password, String email, Set<AbstractAccount> accounts) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.accounts = accounts;
        isLoggedIn = false;
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
        if (!username.matches("[a-zA-Z0-9]{3,}") || String.valueOf(username.charAt(0)).matches("\\d") ) {
            throw new IllegalArgumentException("Incorrect username");
        }
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        validatePassword(password);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (!email.matches("^[a-zA-Z0-9]+([.\\-_]*[a-zA-Z0-9]+)*@[a-zA-Z]+(\\.[a-zA-Z]+)+$")) {
            throw new IllegalArgumentException("Incorrect email");
        }
        this.email = email;
    }

    public Set<AbstractAccount> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(Set<AbstractAccount> accounts) {
        this.accounts = accounts;
    }

    private void validatePassword(String password) {
        if (password.length() <= 6) {
            throw new IllegalArgumentException("Incorrect password");
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (hasUpper && hasLower && hasDigit) {
                break;
            }
        }
        if (!(hasDigit && hasUpper && hasLower)) {
            throw new IllegalArgumentException("Incorrect password");
        }
        this.password = password;
    }

    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
