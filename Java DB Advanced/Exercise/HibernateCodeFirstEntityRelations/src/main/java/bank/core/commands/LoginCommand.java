package bank.core.commands;

import bank.annotations.Inject;
import bank.core.Executable;
import bank.entities.User;
import bank.services.UserService;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

public class LoginCommand implements Executable {
    @Inject
    private String[] params;
    @Inject
    private UserService userService;

    @Override
    public String execute() {
        if (this.params.length < 2) {
            throw new IllegalArgumentException("Incorrect username / password");
        }
        User userByLoggedIn = this.userService.findUserByLoggedInIsTrue();
        if (userByLoggedIn != null) {
            throw new IllegalStateException("Please first logout current user!");
        }

        User user = this.userService.findUserByUsernameAndPassword(this.params[0], this.params[1]);

        if (user == null) {
            throw new IllegalArgumentException("Incorrect username / password");
        }

        if(user.isLoggedIn()) {
            throw new IllegalStateException("User already logged in!");
        }

        if (!user.isLoggedIn()) {
            user.setLoggedIn(true);
            this.userService.create(user);
        }
        return String.format("Successfully logged in %s", user.getUsername());
    }
}