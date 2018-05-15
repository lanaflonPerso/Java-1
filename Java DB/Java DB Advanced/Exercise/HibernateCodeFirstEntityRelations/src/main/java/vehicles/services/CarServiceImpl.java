package vehicles.services;

import vehicles.entities.Car;
import vehicles.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return this.carRepository.findAll();
    }

    @Override
    public Car findById(long id) {
        return this.carRepository.findOne(id);
    }

    @Override
    public Car create(Car car) {
        return this.carRepository.save(car);
    }

    @Override
    public List<Car> multipleCreate(Iterable<Car> cars) {
        return this.carRepository.save(cars);
    }

    @Override
    public void deleteById(long id) {
        this.carRepository.delete(id);
    }

}
