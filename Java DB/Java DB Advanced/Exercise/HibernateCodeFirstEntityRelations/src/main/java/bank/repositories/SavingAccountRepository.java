package bank.repositories;

import bank.entities.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingAccountRepository extends JpaRepository<SavingAccount, Long> {
    SavingAccount findSavingAccountByAccountNumber(String accountNumber);
}
