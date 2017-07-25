package betting.services;

import betting.entities.Continent;
import betting.repositories.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ContinentServiceImpl implements ContinentService {

    private final ContinentRepository continentRepository;

    @Autowired
    public ContinentServiceImpl(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    @Override
    public List<Continent> findAll() {
        return this.continentRepository.findAll();
    }

    @Override
    public Continent findById(long id) {
        return this.continentRepository.findOne(id);
    }

    @Override
    public Continent create(Continent continent) {
        return this.continentRepository.save(continent);
    }

    @Override
    public List<Continent> multipleCreate(Iterable<Continent> continents) {
        return this.continentRepository.save(continents);
    }

    @Override
    public void deleteById(long id) {
        this.continentRepository.delete(id);
    }

}
