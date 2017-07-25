package betting.services;

import betting.entities.Country;
import betting.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country findById(long id) {
        return this.countryRepository.findOne(id);
    }

    @Override
    public Country create(Country country) {
        return this.countryRepository.save(country);
    }

    @Override
    public List<Country> multipleCreate(Iterable<Country> countrys) {
        return this.countryRepository.save(countrys);
    }

    @Override
    public void deleteById(long id) {
        this.countryRepository.delete(id);
    }

}
