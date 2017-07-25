package hotel.services;

import hotel.entities.Occupancy;
import hotel.repositories.OccupancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class OccupancyServiceImpl implements OccupancyService {

    private final OccupancyRepository occupancyRepository;

    @Autowired
    public OccupancyServiceImpl(OccupancyRepository occupancyRepository) {
        this.occupancyRepository = occupancyRepository;
    }

    @Override
    public List<Occupancy> findAll() {
        return this.occupancyRepository.findAll();
    }

    @Override
    public Occupancy findById(long id) {
        return this.occupancyRepository.findOne(id);
    }

    @Override
    public Occupancy create(Occupancy occupancy) {
        return this.occupancyRepository.save(occupancy);
    }

    @Override
    public List<Occupancy> multipleCreate(Iterable<Occupancy> occupancys) {
        return this.occupancyRepository.save(occupancys);
    }

    @Override
    public void deleteById(long id) {
        this.occupancyRepository.delete(id);
    }

}
