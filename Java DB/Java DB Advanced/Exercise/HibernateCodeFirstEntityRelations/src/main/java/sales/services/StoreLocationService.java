package sales.services;

import sales.entities.StoreLocation;

import java.util.List;

public interface StoreLocationService {

    List<StoreLocation> findAll();

    StoreLocation findById(long id);

    StoreLocation create(StoreLocation storelocation);

    List<StoreLocation> multipleCreate(Iterable<StoreLocation> storelocations);

    void deleteById(long id);
}
