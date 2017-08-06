package photographers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import photographers.entities.Photographer;

import java.util.List;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer, Long>, PhotographerRepositoryCustom {

    List<Photographer> getPhotographersByOrderByFirstNameAscLastNameDesc();

    @Query(value = "SELECT * FROM photographers_db.photographers AS p INNER JOIN photographers_db.dslr_cameras AS d ON p.primary_camera_id = d.camera_id ORDER BY p.first_name", nativeQuery = true)
    List<Photographer> getPhotographersByPrimaryCamera();

    @Query(value = "SELECT p.*\n" +
            "FROM photographers AS p\n" +
            "  LEFT JOIN cameras AS c1\n" +
            "    ON p.primary_camera_id = c1.camera_id\n" +
            "  LEFT JOIN cameras AS c2\n" +
            "    ON p.secondary_camera_id = c2.camera_id\n" +
            "WHERE c1.make = c2.make;", nativeQuery = true)
    List<Photographer> getPhotographerWithSameCameras();
}
