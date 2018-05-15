package student.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import student.system.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u.* FROM db_for_all_tasks.users AS u WHERE u.is_deleted = TRUE", nativeQuery = true)
    List<User> findDeletedUsers();
}
