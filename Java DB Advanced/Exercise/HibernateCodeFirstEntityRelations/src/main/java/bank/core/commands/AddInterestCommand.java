package bank.core.commands;

import bank.annotations.Inject;
import bank.core.Executable;
import bank.entities.SavingAccount;
import bank.services.SavingAccountService;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */
public class AddInterestCommand implements Executable {
    @Inject
    private String[] params;
    @Inject
    private SavingAccountService savingAccountService;

    @Override
    public String execute() throws ClassNotFoundException, InvocationTargetException, InstantiationException, NoSuchMethodException, IllegalAccessException {
        SavingAccount savingAccount = this.savingAccountService.findSavingAccountByAccountNumber(this.params[0]);

        if (savingAccount == null) {
            throw new IllegalArgumentException("Account not exist!");
        }
        savingAccount.addInterest();
        this.savingAccountService.create(savingAccount);

        return String.format("Added interest to %s. Current balance: %.2f", savingAccount.getAccountNumber(), savingAccount.getBalance());
    }
}
