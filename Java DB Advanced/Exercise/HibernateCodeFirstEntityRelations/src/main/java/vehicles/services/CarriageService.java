package vehicles.services;

import vehicles.entities.Carriage;

import java.util.List;

public interface CarriageService {

    List<Carriage> findAll();

    Carriage findById(long id);

    Carriage create(Carriage carriage);

    List<Carriage> multipleCreate(Iterable<Carriage> carriages);

    void deleteById(long id);
}
