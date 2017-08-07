package photography.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import photography.entities.Photographer;

import java.util.List;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer, Long> {

    List<Photographer> getPhotographersByOrderByFirstNameAscLastNameDesc();

    @Query(value = "SELECT *\n" +
            "FROM photographers AS p\n" +
            "  INNER JOIN dslr_cameras AS dc\n" +
            "    ON p.primary_camera_id = dc.camera_id\n" +
            "  INNER JOIN lenses AS l\n" +
            "    ON p.photographer_id = l.lens_owner_id\n" +
            "       AND l.focal_length <= 30\n" +
            "ORDER BY p.first_name", nativeQuery = true)
    List<Photographer> getLandscapePhotographers();


    @Query(value = "SELECT *\n" +
            "FROM photographers AS p\n" +
            "  INNER JOIN cameras AS c1\n" +
            "    ON p.primary_camera_id = c1.camera_id\n" +
            "  INNER JOIN cameras AS c2\n" +
            "    ON p.secondary_camera_id = c2.camera_id\n" +
            "WHERE c1.make = c2.make;", nativeQuery = true)
    List<Photographer> getSameCamerasPhotographers();
}
