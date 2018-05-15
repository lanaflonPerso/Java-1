package hotel.services;

import hotel.entities.BedType;
import hotel.repositories.BedTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BedTypeServiceImpl implements BedTypeService {

    private final BedTypeRepository bedtypeRepository;

    @Autowired
    public BedTypeServiceImpl(BedTypeRepository bedtypeRepository) {
        this.bedtypeRepository = bedtypeRepository;
    }

    @Override
    public List<BedType> findAll() {
        return this.bedtypeRepository.findAll();
    }

    @Override
    public BedType findById(long id) {
        return this.bedtypeRepository.findOne(id);
    }

    @Override
    public BedType create(BedType bedtype) {
        return this.bedtypeRepository.save(bedtype);
    }

    @Override
    public List<BedType> multipleCreate(Iterable<BedType> bedtypes) {
        return this.bedtypeRepository.save(bedtypes);
    }

    @Override
    public void deleteById(long id) {
        this.bedtypeRepository.delete(id);
    }

}
