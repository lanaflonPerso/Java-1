package vehicles.services;

import vehicles.entities.Vehicle;
import vehicles.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> findAll() {
        return this.vehicleRepository.findAll();
    }

    @Override
    public Vehicle findById(long id) {
        return this.vehicleRepository.findOne(id);
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        return this.vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> multipleCreate(Iterable<Vehicle> vehicles) {
        return this.vehicleRepository.save(vehicles);
    }

    @Override
    public void deleteById(long id) {
        this.vehicleRepository.delete(id);
    }

}
