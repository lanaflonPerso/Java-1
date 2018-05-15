package vehicles.services;

import vehicles.entities.Carriage;
import vehicles.repositories.CarriageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CarriageServiceImpl implements CarriageService {

    private final CarriageRepository carriageRepository;

    @Autowired
    public CarriageServiceImpl(CarriageRepository carriageRepository) {
        this.carriageRepository = carriageRepository;
    }

    @Override
    public List<Carriage> findAll() {
        return this.carriageRepository.findAll();
    }

    @Override
    public Carriage findById(long id) {
        return this.carriageRepository.findOne(id);
    }

    @Override
    public Carriage create(Carriage carriage) {
        return this.carriageRepository.save(carriage);
    }

    @Override
    public List<Carriage> multipleCreate(Iterable<Carriage> carriages) {
        return this.carriageRepository.save(carriages);
    }

    @Override
    public void deleteById(long id) {
        this.carriageRepository.delete(id);
    }

}
