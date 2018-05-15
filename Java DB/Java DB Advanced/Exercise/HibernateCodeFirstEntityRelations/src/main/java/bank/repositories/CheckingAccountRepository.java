package bank.repositories;

import bank.entities.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long> {
    CheckingAccount findCheckingAccountByAccountNumber(String accountNumber);

}
