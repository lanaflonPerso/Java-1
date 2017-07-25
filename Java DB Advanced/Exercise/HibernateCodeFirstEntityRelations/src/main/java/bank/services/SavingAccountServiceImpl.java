package bank.services;

import bank.entities.SavingAccount;
import bank.repositories.SavingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class SavingAccountServiceImpl implements SavingAccountService {

    private final SavingAccountRepository savingaccountRepository;

    @Autowired
    public SavingAccountServiceImpl(SavingAccountRepository savingaccountRepository) {
        this.savingaccountRepository = savingaccountRepository;
    }

    @Override
    public List<SavingAccount> findAll() {
        return this.savingaccountRepository.findAll();
    }

    @Override
    public SavingAccount findById(long id) {
        return this.savingaccountRepository.findOne(id);
    }

    @Override
    public SavingAccount create(SavingAccount savingaccount) {
        return this.savingaccountRepository.save(savingaccount);
    }

    @Override
    public List<SavingAccount> multipleCreate(Iterable<SavingAccount> savingaccounts) {
        return this.savingaccountRepository.save(savingaccounts);
    }

    @Override
    public void deleteById(long id) {
        this.savingaccountRepository.delete(id);
    }

    @Override
    public SavingAccount findSavingAccountByAccountNumber(String accountNumber) {
        return this.savingaccountRepository.findSavingAccountByAccountNumber(accountNumber);
    }

}
