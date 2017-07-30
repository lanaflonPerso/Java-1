package game.controllers;

import game.annotations.Command;
import game.dto.UserDto;
import game.entities.User;
import game.services.UserService;
import game.utilities.MapperConverter;
import game.utilities.Tokens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Hristo Skipernov on 29/07/2017.
 */

@Controller
public class UserController {

    private final UserService userService;
    private final Tokens tokens;
    private final MapperConverter mapperConverter;

    @Autowired
    public UserController(UserService userService, Tokens tokens, MapperConverter mapperConverter) {
        this.userService = userService;
        this.tokens = tokens;
        this.mapperConverter = mapperConverter;
    }

    @Command(name = "Register")
    public String register() {
        String[] tokens = this.tokens.getCommandTokens();
        if (tokens.length != 4) {
            return "Wrong number of arguments";
        }
        String email = tokens[0];
        String password = tokens[1];
        String confirmPassword = tokens[2];
        String fullName = tokens[3];
        if (!password.equals(confirmPassword)) {
            return "Passwords mismatch";
        }

        UserDto userDto = new UserDto();
        userDto.setEmail(email);
        userDto.setPassword(password);
        userDto.setFullName(fullName);

        User user;
        try {
            user = this.mapperConverter.convertOne(userDto, User.class);

            this.userService.createOne(user);

        } catch (Exception e) {
            return e.getMessage();
        }
        return String.format("%s was registered", user.getFullName());
    }

    @Command(name = "Login")
    public String login() {
        String[] tokens = this.tokens.getCommandTokens();
        if (tokens.length != 2) {
            return "Wrong number of arguments";
        }
        String email = tokens[0];
        String password = tokens[1];
        User user = this.userService.findUserByCredentials(email, password);

        if (user == null) {
            return "Incorrect credentials";
        }

        User loggedInUser = this.userService.findUserByLoggedInIsTrue();

        if (loggedInUser != null) {
            return "Please first logout, before logged in again";
        }
        UserDto userDto = this.mapperConverter.convertOne(user, UserDto.class);
        userDto.setLoggedIn(true);
        this.mapperConverter.convertOne(userDto, user);
        this.userService.updateOne(user);

        return String.format("Successfully logged in %s", user.getFullName());
    }

    @Command(name = "Logout")
    public String logout() {
        User user = this.userService.findUserByLoggedInIsTrue();
        if (user == null) {
            return "Cannot log out. No user was logged in.";
        }
        UserDto userDto = this.mapperConverter.convertOne(user, UserDto.class);
        userDto.setLoggedIn(false);
        this.mapperConverter.convertOne(userDto, user);
        this.userService.updateOne(user);
        return String.format("%s successfully logged out", user.getFullName());
    }
}
