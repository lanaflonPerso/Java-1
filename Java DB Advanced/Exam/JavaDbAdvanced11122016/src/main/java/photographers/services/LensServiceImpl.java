package photographers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import photographers.dtos.bindings.LensImportDto;
import photographers.entities.Lens;
import photographers.io.Writer;
import photographers.repositories.LensRepository;
import photographers.utilities.MapperConverter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Transactional
@Service
public class LensServiceImpl implements LensService {
    private static final String SUCCESSFULLY_IMPORTED_LENS = "Successfully imported %s %dmm f%.1f";

    private final LensRepository lensRepository;
    private final MapperConverter mapperConverter;
    private final Writer writer;

    @Autowired
    public LensServiceImpl(LensRepository lensRepository, MapperConverter mapperConverter, Writer writer) {
        this.lensRepository = lensRepository;
        this.mapperConverter = mapperConverter;
        this.writer = writer;
    }

    @Override
    public List<Lens> findAll() {
        return this.lensRepository.findAll();
    }

    @Override
    public Lens findById(long id) {
        return this.lensRepository.findOne(id);
    }

    @Override
    public Lens createOne(Lens lens) {
        return this.lensRepository.save(lens);
    }

    @Override
    public List<Lens> createMany(List<LensImportDto> lensImportDtos) {
        Lens[] lenses = this.mapperConverter.convert(lensImportDtos, Lens[].class);
        List<Lens> lensList = new ArrayList<>();
        for (Lens lens : lenses) {
            lensList.add(this.createOne(lens));
            this.writer.println(SUCCESSFULLY_IMPORTED_LENS, lens.getMake(), lens.getFocalLength(), lens.getMaxAperture());
        }
        return lensList;
    }

    @Override
    public Lens updateOne(Lens lens) {
        return this.lensRepository.save(lens);
    }

    @Override
    public List<Lens> updateMany(Iterable<Lens> lenss) {
        return this.lensRepository.save(lenss);
    }

    @Override
    @Modifying
    public void deleteById(long id) {
        this.lensRepository.delete(id);
    }

    @Override
    @Modifying
    public void deleteByLens(Lens lens) {
        this.lensRepository.delete(lens);
    }

}
