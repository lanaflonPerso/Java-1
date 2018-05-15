package bank.services;

import bank.entities.CheckingAccount;
import bank.repositories.CheckingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CheckingAccountServiceImpl implements CheckingAccountService {

    private final CheckingAccountRepository checkingaccountRepository;

    @Autowired
    public CheckingAccountServiceImpl(CheckingAccountRepository checkingaccountRepository) {
        this.checkingaccountRepository = checkingaccountRepository;
    }

    @Override
    public List<CheckingAccount> findAll() {
        return this.checkingaccountRepository.findAll();
    }

    @Override
    public CheckingAccount findById(long id) {
        return this.checkingaccountRepository.findOne(id);
    }

    @Override
    public CheckingAccount create(CheckingAccount checkingaccount) {
        return this.checkingaccountRepository.save(checkingaccount);
    }

    @Override
    public List<CheckingAccount> multipleCreate(Iterable<CheckingAccount> checkingaccounts) {
        return this.checkingaccountRepository.save(checkingaccounts);
    }

    @Override
    public void deleteById(long id) {
        this.checkingaccountRepository.delete(id);
    }

    @Override
    public CheckingAccount findCheckingAccountByAccountNumber(String accountNumber) {
        return this.checkingaccountRepository.findCheckingAccountByAccountNumber(accountNumber);
    }

}
