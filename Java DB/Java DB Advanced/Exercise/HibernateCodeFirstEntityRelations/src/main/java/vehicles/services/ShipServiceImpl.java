package vehicles.services;

import vehicles.entities.Ship;
import vehicles.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;

    @Autowired
    public ShipServiceImpl(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    @Override
    public List<Ship> findAll() {
        return this.shipRepository.findAll();
    }

    @Override
    public Ship findById(long id) {
        return this.shipRepository.findOne(id);
    }

    @Override
    public Ship create(Ship ship) {
        return this.shipRepository.save(ship);
    }

    @Override
    public List<Ship> multipleCreate(Iterable<Ship> ships) {
        return this.shipRepository.save(ships);
    }

    @Override
    public void deleteById(long id) {
        this.shipRepository.delete(id);
    }

}
