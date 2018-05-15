package photography.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import photography.entities.Lens;

import java.util.Collection;
import java.util.List;

@Repository
public interface LensRepository extends JpaRepository<Lens, Long> {

    @Query(value = "SELECT l.*\n" +
            "  FROM lenses AS l\n" +
            "WHERE l.lens_id IN :lenses\n" +
            "AND l.compatible_with IS NOT NULL", nativeQuery = true)
    List<Lens> getLenses(@Param("lenses") Collection<Long> lensesId);

    long countByLensOwnerId(long lensOwnerId);
}
