package gringotts.services;

import gringotts.entities.WizardDeposit;
import gringotts.repositories.WizardDepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class WizardDepositServiceImpl implements WizardDepositService {

    private final WizardDepositRepository wizarddepositRepository;

    @Autowired
    public WizardDepositServiceImpl(WizardDepositRepository wizarddepositRepository) {
        this.wizarddepositRepository = wizarddepositRepository;
    }

    @Override
    public List<WizardDeposit> findAll() {
        return this.wizarddepositRepository.findAll();
    }

    @Override
    public WizardDeposit findById(long id) {
        return this.wizarddepositRepository.findOne(id);
    }

    @Override
    public WizardDeposit create(WizardDeposit wizarddeposit) {
        return this.wizarddepositRepository.save(wizarddeposit);
    }

    @Override
    public List<WizardDeposit> multipleCreate(Iterable<WizardDeposit> wizarddeposits) {
        return this.wizarddepositRepository.save(wizarddeposits);
    }

    @Override
    public void deleteById(long id) {
        this.wizarddepositRepository.delete(id);
    }

}
