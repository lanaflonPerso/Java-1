package vehicles.services;

import vehicles.entities.Locomotive;
import vehicles.repositories.LocomotiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class LocomotiveServiceImpl implements LocomotiveService {

    private final LocomotiveRepository locomotiveRepository;

    @Autowired
    public LocomotiveServiceImpl(LocomotiveRepository locomotiveRepository) {
        this.locomotiveRepository = locomotiveRepository;
    }

    @Override
    public List<Locomotive> findAll() {
        return this.locomotiveRepository.findAll();
    }

    @Override
    public Locomotive findById(long id) {
        return this.locomotiveRepository.findOne(id);
    }

    @Override
    public Locomotive create(Locomotive locomotive) {
        return this.locomotiveRepository.save(locomotive);
    }

    @Override
    public List<Locomotive> multipleCreate(Iterable<Locomotive> locomotives) {
        return this.locomotiveRepository.save(locomotives);
    }

    @Override
    public void deleteById(long id) {
        this.locomotiveRepository.delete(id);
    }

}
