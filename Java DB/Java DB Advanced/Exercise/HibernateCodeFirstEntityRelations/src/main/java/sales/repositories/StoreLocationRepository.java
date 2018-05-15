package sales.repositories;

import sales.entities.StoreLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreLocationRepository extends JpaRepository<StoreLocation, Long> {
}
