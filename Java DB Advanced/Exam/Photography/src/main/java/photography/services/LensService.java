package photography.services;

import photography.dtos.bindings.LensImportFromJsonDto;
import photography.entities.Lens;

import java.util.List;

public interface LensService {

    List<Lens> findAll();

    Lens findById(long id);

    Lens createOne(Lens lens);

    List<Lens> createMany(Iterable<LensImportFromJsonDto> lensImportDtos);

    Lens updateOne(Lens lens);

    List<Lens> updateMany(Iterable<Lens> lenss);

    void deleteById(long id);

    void deleteByLens(Lens lens);

    long countByLensOwnerId(long lensOwnerId);
}
