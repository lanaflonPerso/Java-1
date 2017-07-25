package sales.services;

import sales.entities.StoreLocation;
import sales.repositories.StoreLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class StoreLocationServiceImpl implements StoreLocationService {

    private final StoreLocationRepository storelocationRepository;

    @Autowired
    public StoreLocationServiceImpl(StoreLocationRepository storelocationRepository) {
        this.storelocationRepository = storelocationRepository;
    }

    @Override
    public List<StoreLocation> findAll() {
        return this.storelocationRepository.findAll();
    }

    @Override
    public StoreLocation findById(long id) {
        return this.storelocationRepository.findOne(id);
    }

    @Override
    public StoreLocation create(StoreLocation storelocation) {
        return this.storelocationRepository.save(storelocation);
    }

    @Override
    public List<StoreLocation> multipleCreate(Iterable<StoreLocation> storelocations) {
        return this.storelocationRepository.save(storelocations);
    }

    @Override
    public void deleteById(long id) {
        this.storelocationRepository.delete(id);
    }

}
