package vehicles.services;

import vehicles.entities.Train;
import vehicles.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TrainServiceImpl implements TrainService {

    private final TrainRepository trainRepository;

    @Autowired
    public TrainServiceImpl(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    @Override
    public List<Train> findAll() {
        return this.trainRepository.findAll();
    }

    @Override
    public Train findById(long id) {
        return this.trainRepository.findOne(id);
    }

    @Override
    public Train create(Train train) {
        return this.trainRepository.save(train);
    }

    @Override
    public List<Train> multipleCreate(Iterable<Train> trains) {
        return this.trainRepository.save(trains);
    }

    @Override
    public void deleteById(long id) {
        this.trainRepository.delete(id);
    }

}
