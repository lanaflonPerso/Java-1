package photographers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import photographers.dtos.bindings.CameraImportDto;
import photographers.entities.Camera;
import photographers.entities.DSLR;
import photographers.entities.Mirrorless;
import photographers.exceptions.InvalidDataProvidedException;
import photographers.io.Writer;
import photographers.repositories.CameraRepository;
import photographers.utilities.MapperConverter;
import photographers.validators.DTOValidator;

import java.util.ArrayList;
import java.util.List;

import static photographers.constants.ErrorMessage.ERROR_INVALID_DATA_PROVIDED;

@Transactional
@Service
public class CameraServiceImpl implements CameraService {
    private static final String SUCCESSFULLY_IMPORTED_CAMERA = "Successfully imported %s %s %s";

    private final CameraRepository cameraRepository;
    private final MapperConverter mapperConverter;
    private final Writer writer;

    @Autowired
    public CameraServiceImpl(CameraRepository cameraRepository, MapperConverter mapperConverter, Writer writer) {
        this.cameraRepository = cameraRepository;
        this.mapperConverter = mapperConverter;
        this.writer = writer;
    }

    @Override
    public List<Camera> findAll() {
        return this.cameraRepository.findAll();
    }

    @Override
    public Camera findById(long id) {
        return this.cameraRepository.findOne(id);
    }

    @Override
    public Camera createOne(Camera camera) {
        return this.cameraRepository.save(camera);
    }

    @Override
    public List<Camera> createMany(List<CameraImportDto> cameraImportDtos) {
        List<Camera> cameras = new ArrayList<>();
        for (CameraImportDto cameraImportDto : cameraImportDtos) {
            try {
                Camera camera = null;
                if (cameraImportDto.getType() == null) {
                    throw new InvalidDataProvidedException(ERROR_INVALID_DATA_PROVIDED);
                } else if (cameraImportDto.getType().equals(DSLR.class.getSimpleName())) {
                    camera = this.mapperConverter.convert(cameraImportDto, DSLR.class);
                } else if ((cameraImportDto.getType().equals(Mirrorless.class.getSimpleName()))) {
                    camera = this.mapperConverter.convert(cameraImportDto, Mirrorless.class);
                }
                if (DTOValidator.isValid(camera)) {
                    cameras.add(camera);
                    this.createOne(camera);
                    this.writer.println(SUCCESSFULLY_IMPORTED_CAMERA, cameraImportDto.getType(), camera.getMake(), camera.getModel());
                } else {
                    throw new InvalidDataProvidedException(ERROR_INVALID_DATA_PROVIDED);
                }
            } catch (InvalidDataProvidedException idpe) {
                this.writer.println(idpe.getMessage());
            }
        }

        return cameras;
    }

    @Override
    public Camera updateOne(Camera camera) {
        return this.cameraRepository.save(camera);
    }

    @Override
    public List<Camera> updateMany(Iterable<Camera> cameras) {
        return this.cameraRepository.save(cameras);
    }

    @Override
    @Modifying
    public void deleteById(long id) {
        this.cameraRepository.delete(id);
    }

    @Override
    @Modifying
    public void deleteByCamera(Camera camera) {
        this.cameraRepository.delete(camera);
    }

}
