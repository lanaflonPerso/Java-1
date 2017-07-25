package bank.core.commands;

import bank.annotations.Inject;
import bank.core.Executable;
import bank.entities.AbstractAccount;
import bank.services.AbstractAccountService;

import java.util.List;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */
public class ListAccountsCommand implements Executable {
    public static final String SAVING_ACCOUNT_NAME = "SavingAccount";
    public static final String CHECKING_ACCOUNT_NAME = "CheckingAccount";
    @Inject
    private AbstractAccountService abstractAccountService;

    @Override
    public String execute() {
        StringBuilder sb = new StringBuilder();
        List<AbstractAccount> allAccounts = this.abstractAccountService.findAll();
        sb.append("Saving Accounts:").append(System.lineSeparator());
        for (AbstractAccount account : allAccounts) {
            String name = account.getClass().getSimpleName();
            if (name.equals(SAVING_ACCOUNT_NAME)) {
                sb.append(account.toString()).append(System.lineSeparator());
            }
        }
        sb.append("Checking Accounts:").append(System.lineSeparator());
        for (AbstractAccount account : allAccounts) {
            String name = account.getClass().getSimpleName();
            if (name.equals(CHECKING_ACCOUNT_NAME)) {
                sb.append(account.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
