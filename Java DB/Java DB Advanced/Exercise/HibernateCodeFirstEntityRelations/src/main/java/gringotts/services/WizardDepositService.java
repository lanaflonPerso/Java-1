package gringotts.services;

import gringotts.entities.WizardDeposit;

import java.util.List;

public interface WizardDepositService {

    List<WizardDeposit> findAll();

    WizardDeposit findById(long id);

    WizardDeposit create(WizardDeposit wizarddeposit);

    List<WizardDeposit> multipleCreate(Iterable<WizardDeposit> wizarddeposits);

    void deleteById(long id);
}
