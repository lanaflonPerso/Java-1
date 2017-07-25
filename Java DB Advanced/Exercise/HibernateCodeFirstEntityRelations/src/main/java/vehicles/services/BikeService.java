package vehicles.services;

import vehicles.entities.Bike;

import java.util.List;

public interface BikeService {

    List<Bike> findAll();

    Bike findById(long id);

    Bike create(Bike bike);

    List<Bike> multipleCreate(Iterable<Bike> bikes);

    void deleteById(long id);
}
