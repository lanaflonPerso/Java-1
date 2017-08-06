package photographers.services;

import photographers.entities.Mirrorless;

import java.util.List;

public interface MirrorlessService {

    List<Mirrorless> findAll();

    Mirrorless findById(long id);

    Mirrorless createOne(Mirrorless mirrorless);

    List<Mirrorless> createMany(Iterable<Mirrorless> mirrorlesss);

    Mirrorless updateOne(Mirrorless mirrorless);

    List<Mirrorless> updateMany(Iterable<Mirrorless> mirrorlesss);

    void deleteById(long id);

    void deleteByMirrorless(Mirrorless mirrorless);
}
