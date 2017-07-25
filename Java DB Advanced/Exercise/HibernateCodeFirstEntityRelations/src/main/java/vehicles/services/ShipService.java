package vehicles.services;

import vehicles.entities.Ship;

import java.util.List;

public interface ShipService {

    List<Ship> findAll();

    Ship findById(long id);

    Ship create(Ship ship);

    List<Ship> multipleCreate(Iterable<Ship> ships);

    void deleteById(long id);
}
