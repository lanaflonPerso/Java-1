package bank.services;

import bank.entities.SavingAccount;

import java.util.List;

public interface SavingAccountService {

    List<SavingAccount> findAll();

    SavingAccount findById(long id);

    SavingAccount create(SavingAccount savingaccount);

    List<SavingAccount> multipleCreate(Iterable<SavingAccount> savingaccounts);

    void deleteById(long id);

    SavingAccount findSavingAccountByAccountNumber(String accountNumber);
}
