package wedding.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import wedding.entities.Agency;

import java.util.List;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {

    List<Agency> getAgencyByName(String name);

    List<Agency> getAgenciesByOrderByEmployeesCountDesc();

    @Query(value = "SELECT a.*\n" +
            "FROM agencies AS a\n" +
            "  INNER JOIN weddings AS w\n" +
            "  ON a.agency_id = w.agency_id\n" +
            "WHERE length(a.town) >= 6\n" +
            "  GROUP BY a.agency_id\n" +
            "HAVING count(w.wedding_id) >= 2;", nativeQuery = true)
    List<Agency> getAgenciesByTown();
}
