package photographers.services;

import photographers.entities.DSLR;
import photographers.repositories.DSLRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DSLRServiceImpl implements DSLRService {

    private final DSLRRepository dSLRRepository;

    @Autowired
    public DSLRServiceImpl(DSLRRepository dSLRRepository) {
        this.dSLRRepository = dSLRRepository;
    }

    @Override
    public List<DSLR> findAll() {
        return this.dSLRRepository.findAll();
    }

    @Override
    public DSLR findById(long id) {
        return this.dSLRRepository.findOne(id);
    }

    @Override
    public DSLR createOne(DSLR dSLR) {
        return this.dSLRRepository.save(dSLR);
    }

    @Override
    public List<DSLR> createMany(Iterable<DSLR> dSLRs) {
        return this.dSLRRepository.save(dSLRs);
    }

    @Override
    public DSLR updateOne(DSLR dSLR) {
        return this.dSLRRepository.save(dSLR);
    }

    @Override
    public List<DSLR> updateMany(Iterable<DSLR> dSLRs) {
        return this.dSLRRepository.save(dSLRs);
    }

    @Override
    @Modifying
    public void deleteById(long id) {
        this.dSLRRepository.delete(id);
    }

    @Override
    @Modifying
    public void deleteByDSLR(DSLR dSLR) {
        this.dSLRRepository.delete(dSLR);
    }

}
