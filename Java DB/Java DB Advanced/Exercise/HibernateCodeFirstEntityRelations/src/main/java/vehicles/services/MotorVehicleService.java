package vehicles.services;

import vehicles.entities.MotorVehicle;

import java.util.List;

public interface MotorVehicleService {

    List<MotorVehicle> findAll();

    MotorVehicle findById(long id);

    MotorVehicle create(MotorVehicle motorvehicle);

    List<MotorVehicle> multipleCreate(Iterable<MotorVehicle> motorvehicles);

    void deleteById(long id);
}
