package vehicles.repositories;

import vehicles.entities.CargoShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoShipRepository extends JpaRepository<CargoShip, Long> {
}
