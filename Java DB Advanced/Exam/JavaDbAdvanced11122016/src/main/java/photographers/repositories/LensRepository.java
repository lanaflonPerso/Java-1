package photographers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import photographers.entities.Lens;

import java.util.Collection;
import java.util.List;

@Repository
public interface LensRepository extends JpaRepository<Lens, Long> {

    List<Lens> getLensByIdIn(Collection<Long> ids);

    @Modifying
    @Query(value = "UPDATE photographers_db.lenses AS l SET l.lens_owner_id  = :ownerId WHERE l.lens_id IN :lensesIds", nativeQuery = true)
    void addOwner(@Param("ownerId") long photographerId, @Param("lensesIds")Collection<Long> lensesIds);
}
