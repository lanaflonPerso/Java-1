package photographers.repositories;

import org.springframework.stereotype.Repository;
import photographers.entities.Photographer;

@Repository
public interface PhotographerRepositoryCustom {

    Photographer createOneWithLenses(Photographer photographer);
}
