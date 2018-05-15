package vehicles.repositories;

import vehicles.entities.Sleeping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SleepingRepository extends JpaRepository<Sleeping, Long> {
}
