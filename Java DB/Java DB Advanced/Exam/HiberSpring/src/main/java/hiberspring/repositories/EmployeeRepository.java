package hiberspring.repositories;

import hiberspring.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT count(e.employee_id) FROM hiberspring_inc_db.employees AS e INNER JOIN hiberspring_inc_db.employee_cards AS ec ON e.card_id = ec.employee_card_id WHERE ec.employee_card_number = :cardNumber", nativeQuery = true)
    long getEmployeeCountByEmployeeCardNumber(@Param("cardNumber") String cardNumber);

    @Query(value = "SELECT e.*\n" +
            "FROM employees AS e\n" +
            "INNER JOIN branches AS b\n" +
            "ON e.branch_id = b.branch_id\n" +
            "INNER JOIN products AS p\n" +
            "ON b.branch_id = p.branch_id\n" +
            "ORDER BY concat_ws(' ', e.first_name, e.last_name), length(e.position) DESC;", nativeQuery = true)
    List<Employee> getProductiveEmployees();
}
