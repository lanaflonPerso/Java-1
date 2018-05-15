package hotel.services;

import hotel.entities.Occupancy;

import java.util.List;

public interface OccupancyService {

    List<Occupancy> findAll();

    Occupancy findById(long id);

    Occupancy create(Occupancy occupancy);

    List<Occupancy> multipleCreate(Iterable<Occupancy> occupancys);

    void deleteById(long id);
}
