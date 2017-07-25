package vehicles.services;

import vehicles.entities.Train;

import java.util.List;

public interface TrainService {

    List<Train> findAll();

    Train findById(long id);

    Train create(Train train);

    List<Train> multipleCreate(Iterable<Train> trains);

    void deleteById(long id);
}
