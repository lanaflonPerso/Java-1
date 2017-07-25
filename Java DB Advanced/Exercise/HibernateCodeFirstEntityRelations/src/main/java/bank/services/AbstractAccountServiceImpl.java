package bank.services;

import bank.entities.AbstractAccount;
import bank.repositories.AbstractAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AbstractAccountServiceImpl implements AbstractAccountService {

    private final AbstractAccountRepository abstractaccountRepository;

    @Autowired
    public AbstractAccountServiceImpl(AbstractAccountRepository abstractaccountRepository) {
        this.abstractaccountRepository = abstractaccountRepository;
    }

    @Override
    public List<AbstractAccount> findAll() {
        return this.abstractaccountRepository.findAll();
    }

    @Override
    public AbstractAccount findById(long id) {
        return this.abstractaccountRepository.findOne(id);
    }

    @Override
    public AbstractAccount create(AbstractAccount abstractaccount) {
        return this.abstractaccountRepository.save(abstractaccount);
    }

    @Override
    public List<AbstractAccount> multipleCreate(Iterable<AbstractAccount> abstractaccounts) {
        return this.abstractaccountRepository.save(abstractaccounts);
    }

    @Override
    public void deleteById(long id) {
        this.abstractaccountRepository.delete(id);
    }

    @Override
    public AbstractAccount findAbstractAccountByAccountNumber(String accountNumber) {
        return this.abstractaccountRepository.findAbstractAccountByAccountNumber(accountNumber);
    }

}
