package vehicles.repositories;

import vehicles.entities.MotorVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorVehicleRepository extends JpaRepository<MotorVehicle, Long> {
}
