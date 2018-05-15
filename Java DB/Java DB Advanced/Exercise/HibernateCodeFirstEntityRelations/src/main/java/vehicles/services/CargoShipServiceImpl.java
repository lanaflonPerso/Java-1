package vehicles.services;

import vehicles.entities.CargoShip;
import vehicles.repositories.CargoShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CargoShipServiceImpl implements CargoShipService {

    private final CargoShipRepository cargoshipRepository;

    @Autowired
    public CargoShipServiceImpl(CargoShipRepository cargoshipRepository) {
        this.cargoshipRepository = cargoshipRepository;
    }

    @Override
    public List<CargoShip> findAll() {
        return this.cargoshipRepository.findAll();
    }

    @Override
    public CargoShip findById(long id) {
        return this.cargoshipRepository.findOne(id);
    }

    @Override
    public CargoShip create(CargoShip cargoship) {
        return this.cargoshipRepository.save(cargoship);
    }

    @Override
    public List<CargoShip> multipleCreate(Iterable<CargoShip> cargoships) {
        return this.cargoshipRepository.save(cargoships);
    }

    @Override
    public void deleteById(long id) {
        this.cargoshipRepository.delete(id);
    }

}
