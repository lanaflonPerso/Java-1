package photographers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import photographers.entities.Workshop;

import java.util.List;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, Long>, WorkshopRepositoryCustom {

    @Query(value = "SELECT *\n" +
            "FROM workshops AS w\n" +
            "INNER JOIN workshops_photographers AS wp\n" +
            "ON w.workshop_id = wp.workshop_id\n" +
            "GROUP BY w.workshop_id, w.workshop_name\n" +
            "HAVING count(wp.photographer_id) >= 5;", nativeQuery = true)
    List<Workshop> getWorkshopByLocation();
}
