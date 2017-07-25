package student.system.services;

import student.system.entities.Town;
import student.system.repositories.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public List<Town> findAll() {
        return this.townRepository.findAll();
    }

    @Override
    public Town findById(long id) {
        return this.townRepository.findOne(id);
    }

    @Override
    public Town createOne(Town town) {
        return this.townRepository.save(town);
    }

    @Override
    public List<Town> createMany(Iterable<Town> towns) {
        return this.townRepository.save(towns);
    }

    @Override
    public Town updateOne(Town town) {
        return this.townRepository.save(town);
    }

    @Override
    public List<Town> updateMany(Iterable<Town> towns) {
        return this.townRepository.save(towns);
    }

    @Override
    public void deleteById(long id) {
        this.townRepository.delete(id);
    }

}
