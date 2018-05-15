package vehicles.services;

import vehicles.entities.Sleeping;

import java.util.List;

public interface SleepingService {

    List<Sleeping> findAll();

    Sleeping findById(long id);

    Sleeping create(Sleeping sleeping);

    List<Sleeping> multipleCreate(Iterable<Sleeping> sleepings);

    void deleteById(long id);
}
