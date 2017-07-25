package bank.repositories;

import bank.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT u.* FROM bank_db.users AS u WHERE u.is_logged_in = TRUE", nativeQuery = true)
    User findUserByLoggedInIsTrue();
}
