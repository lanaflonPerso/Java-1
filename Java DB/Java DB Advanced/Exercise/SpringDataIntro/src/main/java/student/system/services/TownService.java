package student.system.services;

import student.system.entities.Town;

import java.util.List;

public interface TownService {

    List<Town> findAll();

    Town findById(long id);

    Town createOne(Town town);

    List<Town> createMany(Iterable<Town> towns);

    Town updateOne(Town town);

    List<Town> updateMany(Iterable<Town> towns);

    void deleteById(long id);
}
