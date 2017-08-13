package hiberspring.repositories;

import hiberspring.entities.EmployeeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCardRepository extends JpaRepository<EmployeeCard, Long> {

    EmployeeCard getEmployeeCardByNumber(String number);

    @Query(value = "SELECT ec.*\n" +
            "  FROM employee_cards AS ec\n" +
            "LEFT JOIN employees AS e\n" +
            "    ON ec.employee_card_id = e.card_id\n" +
            "  WHERE e.employee_id IS NULL\n" +
            "ORDER BY ec.employee_card_id;", nativeQuery = true)
    List<EmployeeCard> getUnusedCards();
}
