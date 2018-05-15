package vehicles.services;

import vehicles.entities.Plane;

import java.util.List;

public interface PlaneService {

    List<Plane> findAll();

    Plane findById(long id);

    Plane create(Plane plane);

    List<Plane> multipleCreate(Iterable<Plane> planes);

    void deleteById(long id);
}
