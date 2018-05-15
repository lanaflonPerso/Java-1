package vehicles.services;

import vehicles.entities.NonMotorVehicle;
import vehicles.repositories.NonMotorVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class NonMotorVehicleServiceImpl implements NonMotorVehicleService {

    private final NonMotorVehicleRepository nonmotorvehicleRepository;

    @Autowired
    public NonMotorVehicleServiceImpl(NonMotorVehicleRepository nonmotorvehicleRepository) {
        this.nonmotorvehicleRepository = nonmotorvehicleRepository;
    }

    @Override
    public List<NonMotorVehicle> findAll() {
        return this.nonmotorvehicleRepository.findAll();
    }

    @Override
    public NonMotorVehicle findById(long id) {
        return this.nonmotorvehicleRepository.findOne(id);
    }

    @Override
    public NonMotorVehicle create(NonMotorVehicle nonmotorvehicle) {
        return this.nonmotorvehicleRepository.save(nonmotorvehicle);
    }

    @Override
    public List<NonMotorVehicle> multipleCreate(Iterable<NonMotorVehicle> nonmotorvehicles) {
        return this.nonmotorvehicleRepository.save(nonmotorvehicles);
    }

    @Override
    public void deleteById(long id) {
        this.nonmotorvehicleRepository.delete(id);
    }

}
