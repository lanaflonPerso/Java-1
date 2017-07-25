package vehicles.services;

import vehicles.entities.Plane;
import vehicles.repositories.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PlaneServiceImpl implements PlaneService {

    private final PlaneRepository planeRepository;

    @Autowired
    public PlaneServiceImpl(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    @Override
    public List<Plane> findAll() {
        return this.planeRepository.findAll();
    }

    @Override
    public Plane findById(long id) {
        return this.planeRepository.findOne(id);
    }

    @Override
    public Plane create(Plane plane) {
        return this.planeRepository.save(plane);
    }

    @Override
    public List<Plane> multipleCreate(Iterable<Plane> planes) {
        return this.planeRepository.save(planes);
    }

    @Override
    public void deleteById(long id) {
        this.planeRepository.delete(id);
    }

}
