package photography.repositories;

import org.springframework.data.jpa.repository.Query;
import photography.entities.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, Long> {

    @Query(value = "SELECT w.*\n" +
            "FROM workshops AS w\n" +
            "INNER JOIN workshops_photographers AS wp\n" +
            "ON w.workshop_id = wp.workshop_id\n" +
            "  GROUP BY w.workshop_id\n" +
            "HAVING count(wp.photographer_id) >= 5;", nativeQuery = true)
    List<Workshop> getWorkshopsByLocation();
}
