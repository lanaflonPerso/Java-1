package photographers.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import photographers.entities.Lens;
import photographers.entities.Photographer;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PhotographerRepositoryImpl implements PhotographerRepositoryCustom {

    private final EntityManager em;
    private final LensRepository lensRepository;

    @Autowired
    public PhotographerRepositoryImpl(EntityManager em, LensRepository lensRepository) {
        this.em = em;
        this.lensRepository = lensRepository;
    }

    @Override
    public Photographer createOneWithLenses(Photographer photographer) {
        Photographer photographerMerge = this.em.merge(photographer);
        long id = photographerMerge.getId();
        List<Long> longs = photographerMerge.getLenses().stream().map(Lens::getId).collect(Collectors.toList());
        if (!longs.isEmpty()) {
            this.lensRepository.addOwner(id, longs);
        }
        return photographerMerge;
    }
}
