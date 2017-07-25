package vehicles.repositories;

import vehicles.entities.CruiseShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CruiseShipRepository extends JpaRepository<CruiseShip, Long> {
}
