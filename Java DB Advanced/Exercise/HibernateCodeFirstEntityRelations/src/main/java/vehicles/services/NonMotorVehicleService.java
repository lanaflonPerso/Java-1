package vehicles.services;

import vehicles.entities.NonMotorVehicle;

import java.util.List;

public interface NonMotorVehicleService {

    List<NonMotorVehicle> findAll();

    NonMotorVehicle findById(long id);

    NonMotorVehicle create(NonMotorVehicle nonmotorvehicle);

    List<NonMotorVehicle> multipleCreate(Iterable<NonMotorVehicle> nonmotorvehicles);

    void deleteById(long id);
}
