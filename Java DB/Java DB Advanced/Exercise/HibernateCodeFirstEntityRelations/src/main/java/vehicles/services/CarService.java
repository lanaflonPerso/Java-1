package vehicles.services;

import vehicles.entities.Car;

import java.util.List;

public interface CarService {

    List<Car> findAll();

    Car findById(long id);

    Car create(Car car);

    List<Car> multipleCreate(Iterable<Car> cars);

    void deleteById(long id);
}
