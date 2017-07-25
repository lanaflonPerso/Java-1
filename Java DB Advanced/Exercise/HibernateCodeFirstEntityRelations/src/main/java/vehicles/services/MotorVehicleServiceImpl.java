package vehicles.services;

import vehicles.entities.MotorVehicle;
import vehicles.repositories.MotorVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MotorVehicleServiceImpl implements MotorVehicleService {

    private final MotorVehicleRepository motorvehicleRepository;

    @Autowired
    public MotorVehicleServiceImpl(MotorVehicleRepository motorvehicleRepository) {
        this.motorvehicleRepository = motorvehicleRepository;
    }

    @Override
    public List<MotorVehicle> findAll() {
        return this.motorvehicleRepository.findAll();
    }

    @Override
    public MotorVehicle findById(long id) {
        return this.motorvehicleRepository.findOne(id);
    }

    @Override
    public MotorVehicle create(MotorVehicle motorvehicle) {
        return this.motorvehicleRepository.save(motorvehicle);
    }

    @Override
    public List<MotorVehicle> multipleCreate(Iterable<MotorVehicle> motorvehicles) {
        return this.motorvehicleRepository.save(motorvehicles);
    }

    @Override
    public void deleteById(long id) {
        this.motorvehicleRepository.delete(id);
    }

}
