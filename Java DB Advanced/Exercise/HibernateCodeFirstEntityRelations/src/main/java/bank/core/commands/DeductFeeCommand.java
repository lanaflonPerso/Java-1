package bank.core.commands;

import bank.annotations.Inject;
import bank.core.Executable;
import bank.entities.CheckingAccount;
import bank.services.CheckingAccountService;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */
public class DeductFeeCommand implements Executable {
    @Inject
    private String[] params;
    @Inject
    private CheckingAccountService checkingAccountService;

    @Override
    public String execute() throws ClassNotFoundException, InvocationTargetException, InstantiationException, NoSuchMethodException, IllegalAccessException {
        CheckingAccount checkingAccount = this.checkingAccountService.findCheckingAccountByAccountNumber(this.params[0]);

        if (checkingAccount == null) {
            throw new IllegalArgumentException("Account not exist!");
        }
        checkingAccount.deductFee();
        this.checkingAccountService.create(checkingAccount);

        return String.format("Deducted fee of %s. Current balance: %.2f", checkingAccount.getAccountNumber(), checkingAccount.getBalance());
    }
}
