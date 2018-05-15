package betting.services;

import betting.entities.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAll();

    Country findById(long id);

    Country create(Country country);

    List<Country> multipleCreate(Iterable<Country> countrys);

    void deleteById(long id);
}
