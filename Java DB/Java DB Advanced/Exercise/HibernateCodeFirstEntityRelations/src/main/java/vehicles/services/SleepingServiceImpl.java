package vehicles.services;

import vehicles.entities.Sleeping;
import vehicles.repositories.SleepingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class SleepingServiceImpl implements SleepingService {

    private final SleepingRepository sleepingRepository;

    @Autowired
    public SleepingServiceImpl(SleepingRepository sleepingRepository) {
        this.sleepingRepository = sleepingRepository;
    }

    @Override
    public List<Sleeping> findAll() {
        return this.sleepingRepository.findAll();
    }

    @Override
    public Sleeping findById(long id) {
        return this.sleepingRepository.findOne(id);
    }

    @Override
    public Sleeping create(Sleeping sleeping) {
        return this.sleepingRepository.save(sleeping);
    }

    @Override
    public List<Sleeping> multipleCreate(Iterable<Sleeping> sleepings) {
        return this.sleepingRepository.save(sleepings);
    }

    @Override
    public void deleteById(long id) {
        this.sleepingRepository.delete(id);
    }

}
