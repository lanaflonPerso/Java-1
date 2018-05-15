package vehicles.services;

import vehicles.entities.Locomotive;

import java.util.List;

public interface LocomotiveService {

    List<Locomotive> findAll();

    Locomotive findById(long id);

    Locomotive create(Locomotive locomotive);

    List<Locomotive> multipleCreate(Iterable<Locomotive> locomotives);

    void deleteById(long id);
}
