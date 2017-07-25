package gringotts.repositories;

import gringotts.entities.WizardDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WizardDepositRepository extends JpaRepository<WizardDeposit, Long> {
}
