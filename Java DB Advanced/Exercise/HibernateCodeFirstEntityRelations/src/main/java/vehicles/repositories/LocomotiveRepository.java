package vehicles.repositories;

import vehicles.entities.Locomotive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocomotiveRepository extends JpaRepository<Locomotive, Long> {
}
