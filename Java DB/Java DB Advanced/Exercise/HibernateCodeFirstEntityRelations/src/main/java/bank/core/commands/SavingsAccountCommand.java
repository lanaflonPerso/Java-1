package bank.core.commands;

import bank.annotations.Inject;
import bank.core.Executable;
import bank.entities.SavingAccount;
import bank.entities.User;
import bank.services.AbstractAccountService;
import bank.services.UserService;
import bank.ustilities.RandomAccountNumber;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Component
public class SavingsAccountCommand implements Executable {
    @Inject
    private String[] params;
    @Inject
    private UserService userService;
    @Inject
    private AbstractAccountService abstractAccountService;
    @Inject
    private RandomAccountNumber randomAccountNumber;

    @Override
    public String execute() throws ClassNotFoundException, InvocationTargetException, InstantiationException, NoSuchMethodException, IllegalAccessException {
        User user = this.userService.findUserByLoggedInIsTrue();

        if (!user.isLoggedIn()) {
            throw new IllegalStateException("Please first logged in!");
        }

        SavingAccount account = new SavingAccount();
        account.setBalance(Double.parseDouble(this.params[0]));
        account.setInterestRate(Double.parseDouble(this.params[1]));
        account.setAccountNumber(this.randomAccountNumber.get());
        account.setUser(user);

        this.abstractAccountService.create(account);

        return String.format("Successfully added account with number %s", account.getAccountNumber());
    }
}