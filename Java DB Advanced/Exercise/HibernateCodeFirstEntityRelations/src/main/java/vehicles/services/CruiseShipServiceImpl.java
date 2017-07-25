package vehicles.services;

import vehicles.entities.CruiseShip;
import vehicles.repositories.CruiseShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CruiseShipServiceImpl implements CruiseShipService {

    private final CruiseShipRepository cruiseshipRepository;

    @Autowired
    public CruiseShipServiceImpl(CruiseShipRepository cruiseshipRepository) {
        this.cruiseshipRepository = cruiseshipRepository;
    }

    @Override
    public List<CruiseShip> findAll() {
        return this.cruiseshipRepository.findAll();
    }

    @Override
    public CruiseShip findById(long id) {
        return this.cruiseshipRepository.findOne(id);
    }

    @Override
    public CruiseShip create(CruiseShip cruiseship) {
        return this.cruiseshipRepository.save(cruiseship);
    }

    @Override
    public List<CruiseShip> multipleCreate(Iterable<CruiseShip> cruiseships) {
        return this.cruiseshipRepository.save(cruiseships);
    }

    @Override
    public void deleteById(long id) {
        this.cruiseshipRepository.delete(id);
    }

}
