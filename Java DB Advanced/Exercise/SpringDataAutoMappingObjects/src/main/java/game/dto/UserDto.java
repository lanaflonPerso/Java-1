package game.dto;

/**
 * Created by Hristo Skipernov on 29/07/2017.
 */

public class UserDto {

    private String email;

    private String password;

    private String fullName;

    private boolean loggedIn;

    public UserDto() {
        this.loggedIn = false;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
