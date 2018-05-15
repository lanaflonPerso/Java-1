package bank.services;

import bank.entities.AbstractAccount;

import java.util.List;

public interface AbstractAccountService {

    List<AbstractAccount> findAll();

    AbstractAccount findById(long id);

    AbstractAccount create(AbstractAccount abstractaccount);

    List<AbstractAccount> multipleCreate(Iterable<AbstractAccount> abstractaccounts);

    void deleteById(long id);

    AbstractAccount findAbstractAccountByAccountNumber(String accountNumber);
}
