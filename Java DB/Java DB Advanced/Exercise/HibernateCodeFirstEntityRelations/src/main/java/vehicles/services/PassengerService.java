package vehicles.services;

import vehicles.entities.Passenger;

import java.util.List;

public interface PassengerService {

    List<Passenger> findAll();

    Passenger findById(long id);

    Passenger create(Passenger passenger);

    List<Passenger> multipleCreate(Iterable<Passenger> passengers);

    void deleteById(long id);
}
