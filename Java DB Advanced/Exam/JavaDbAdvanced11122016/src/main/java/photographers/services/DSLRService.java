package photographers.services;

import photographers.entities.DSLR;

import java.util.List;

public interface DSLRService {

    List<DSLR> findAll();

    DSLR findById(long id);

    DSLR createOne(DSLR dslr);

    List<DSLR> createMany(Iterable<DSLR> dslrs);

    DSLR updateOne(DSLR dslr);

    List<DSLR> updateMany(Iterable<DSLR> dslrs);

    void deleteById(long id);

    void deleteByDSLR(DSLR dslr);
}
