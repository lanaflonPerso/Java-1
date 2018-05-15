package wedding.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import wedding.entities.Present;

@Repository
public interface PresentRepository extends JpaRepository<Present, Long> {

    @Query(value = "SELECT p.cash_amount FROM weddings_db.presents AS p WHERE p.present_id = :id", nativeQuery = true)
    Double getPresentCashAmount(@Param("id") long presentId);

    @Query(value = "SELECT p.name FROM weddings_db.presents AS p WHERE p.present_id = :id", nativeQuery = true)
    String getPresentName(@Param("id") long presentId);

    @Query(value = "SELECT p.size FROM weddings_db.presents AS p WHERE p.present_id = :id", nativeQuery = true)
    String getPresentSize(@Param("id") long presentId);
}
