package bank.services;

import bank.entities.CheckingAccount;

import java.util.List;

public interface CheckingAccountService {

    List<CheckingAccount> findAll();

    CheckingAccount findById(long id);

    CheckingAccount create(CheckingAccount checkingaccount);

    List<CheckingAccount> multipleCreate(Iterable<CheckingAccount> checkingaccounts);

    void deleteById(long id);

    CheckingAccount findCheckingAccountByAccountNumber(String accountNumber);
}
