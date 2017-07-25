package vehicles.services;

import vehicles.entities.CargoShip;

import java.util.List;

public interface CargoShipService {

    List<CargoShip> findAll();

    CargoShip findById(long id);

    CargoShip create(CargoShip cargoship);

    List<CargoShip> multipleCreate(Iterable<CargoShip> cargoships);

    void deleteById(long id);
}
