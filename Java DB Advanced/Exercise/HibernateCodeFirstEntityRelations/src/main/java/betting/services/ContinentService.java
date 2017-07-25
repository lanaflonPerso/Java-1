package betting.services;

import betting.entities.Continent;

import java.util.List;

public interface ContinentService {

    List<Continent> findAll();

    Continent findById(long id);

    Continent create(Continent continent);

    List<Continent> multipleCreate(Iterable<Continent> continents);

    void deleteById(long id);
}
