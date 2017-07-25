package vehicles.services;

import vehicles.entities.CruiseShip;

import java.util.List;

public interface CruiseShipService {

    List<CruiseShip> findAll();

    CruiseShip findById(long id);

    CruiseShip create(CruiseShip cruiseship);

    List<CruiseShip> multipleCreate(Iterable<CruiseShip> cruiseships);

    void deleteById(long id);
}
