package vehicles.services;

import vehicles.entities.Bike;
import vehicles.repositories.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BikeServiceImpl implements BikeService {

    private final BikeRepository bikeRepository;

    @Autowired
    public BikeServiceImpl(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @Override
    public List<Bike> findAll() {
        return this.bikeRepository.findAll();
    }

    @Override
    public Bike findById(long id) {
        return this.bikeRepository.findOne(id);
    }

    @Override
    public Bike create(Bike bike) {
        return this.bikeRepository.save(bike);
    }

    @Override
    public List<Bike> multipleCreate(Iterable<Bike> bikes) {
        return this.bikeRepository.save(bikes);
    }

    @Override
    public void deleteById(long id) {
        this.bikeRepository.delete(id);
    }

}
