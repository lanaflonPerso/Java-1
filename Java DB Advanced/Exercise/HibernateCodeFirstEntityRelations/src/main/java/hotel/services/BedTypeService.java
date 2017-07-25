package hotel.services;

import hotel.entities.BedType;

import java.util.List;

public interface BedTypeService {

    List<BedType> findAll();

    BedType findById(long id);

    BedType create(BedType bedtype);

    List<BedType> multipleCreate(Iterable<BedType> bedtypes);

    void deleteById(long id);
}
