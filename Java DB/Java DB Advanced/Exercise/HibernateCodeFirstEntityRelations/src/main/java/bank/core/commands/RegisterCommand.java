package bank.core.commands;

import bank.core.Executable;
import bank.entities.User;
import bank.services.UserService;
import bank.annotations.Inject;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

public class RegisterCommand implements Executable {

    @Inject
    private String[] params;
    @Inject
    private UserService userService;

    @Override
    public String execute() {
        if (this.params.length < 3) {
            throw new IllegalArgumentException("User must contain username, password and email");
        }
        User user = new User();
        user.setUsername(this.params[0]);
        user.setPassword(this.params[1]);
        user.setEmail(this.params[2]);
        this.userService.create(user);

        return String.format("%s was registered in the system", user.getUsername());
    }
}