package bank.core.commands;

import bank.annotations.Inject;
import bank.core.Executable;
import bank.entities.User;
import bank.services.UserService;
import org.springframework.stereotype.Component;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Component
public class LogoutCommand implements Executable {
    @Inject
    private UserService userService;

    @Override
    public String execute() {
        User userByLoggedIn = this.userService.findUserByLoggedInIsTrue();
        if (userByLoggedIn == null) {
            throw new IllegalStateException("Cannot log out. No user was logged in.");
        }

        userByLoggedIn.setLoggedIn(false);

        return String.format("User %s successfully logged out", userByLoggedIn.getUsername());
    }
}