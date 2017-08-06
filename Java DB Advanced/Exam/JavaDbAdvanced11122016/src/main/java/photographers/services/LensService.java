package photographers.services;

import photographers.dtos.bindings.LensImportDto;
import photographers.entities.Lens;

import java.util.List;

public interface LensService {

    List<Lens> findAll();

    Lens findById(long id);

    Lens createOne(Lens lens);

    List<Lens> createMany(List<LensImportDto> lensImportDtos);

    Lens updateOne(Lens lens);

    List<Lens> updateMany(Iterable<Lens> lenss);

    void deleteById(long id);

    void deleteByLens(Lens lens);
}
