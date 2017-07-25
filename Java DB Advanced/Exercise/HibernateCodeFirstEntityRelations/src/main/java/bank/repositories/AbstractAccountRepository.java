package bank.repositories;

import bank.entities.AbstractAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractAccountRepository extends JpaRepository<AbstractAccount, Long> {
    AbstractAccount findAbstractAccountByAccountNumber(String accountNumber);
}
