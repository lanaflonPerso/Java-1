package vehicles.services;

import vehicles.entities.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> findAll();

    Vehicle findById(long id);

    Vehicle create(Vehicle vehicle);

    List<Vehicle> multipleCreate(Iterable<Vehicle> vehicles);

    void deleteById(long id);
}
