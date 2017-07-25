package bank.core.commands;

import bank.annotations.Inject;
import bank.core.Executable;
import bank.entities.AbstractAccount;
import bank.services.AbstractAccountService;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */
public class DepositCommand implements Executable {
    @Inject
    private String[] params;
    @Inject
    private AbstractAccountService abstractAccountService;

    @Override
    public String execute() throws ClassNotFoundException, InvocationTargetException, InstantiationException, NoSuchMethodException, IllegalAccessException {
        AbstractAccount abstractAccount = this.abstractAccountService.findAbstractAccountByAccountNumber(this.params[0]);

        abstractAccount.deposit(Double.parseDouble(this.params[1]));
        this.abstractAccountService.create(abstractAccount);

        return String.format("Account %s has balance of %.2f", abstractAccount.getAccountNumber(), abstractAccount.getBalance());
    }
}
