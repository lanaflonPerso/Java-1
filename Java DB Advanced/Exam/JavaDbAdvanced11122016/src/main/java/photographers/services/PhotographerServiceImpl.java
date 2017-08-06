package photographers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import photographers.dtos.bindings.PhotographerImportDto;
import photographers.dtos.utility.CameraIdAndMakeDto;
import photographers.dtos.utility.LensFocalLengthDto;
import photographers.dtos.utility.LensIdAndCompatibleDto;
import photographers.dtos.views.photographers.LandscapePhotographerViewDto;
import photographers.dtos.views.photographers.PhotographerSameCamerasXmlViewDto;
import photographers.dtos.views.photographers.PhotographerViewDto;
import photographers.dtos.views.photographers.PhotographersSameCamerasXmlViewDto;
import photographers.entities.Camera;
import photographers.entities.Lens;
import photographers.entities.Photographer;
import photographers.io.Writer;
import photographers.repositories.CameraRepository;
import photographers.repositories.LensRepository;
import photographers.repositories.PhotographerRepository;
import photographers.utilities.MapperConverter;
import photographers.utilities.RandomNumber;
import photographers.validators.DTOValidator;

import java.util.*;

import static photographers.constants.ErrorMessage.ERROR_INVALID_DATA_PROVIDED;

@Transactional
@Service
public class PhotographerServiceImpl implements PhotographerService {
    private static final String SUCCESSFULLY_IMPORTED_PHOTOGRAPHER = "Successfully imported %s %s | Lenses: %d";

    private final PhotographerRepository photographerRepository;
    private final CameraRepository cameraRepository;
    private final LensRepository lensRepository;
    private final MapperConverter mapperConverter;
    private final Writer writer;

    @Autowired
    public PhotographerServiceImpl(PhotographerRepository photographerRepository, CameraRepository cameraRepository, LensRepository lensRepository, MapperConverter mapperConverter, Writer writer) {
        this.photographerRepository = photographerRepository;
        this.cameraRepository = cameraRepository;
        this.lensRepository = lensRepository;
        this.mapperConverter = mapperConverter;
        this.writer = writer;
    }

    @Override
    public List<Photographer> findAll() {
        return this.photographerRepository.findAll();
    }

    @Override
    public Photographer findById(long id) {
        return this.photographerRepository.findOne(id);
    }

    @Override
    public Photographer createOne(Photographer photographer) {
        return this.photographerRepository.saveAndFlush(photographer);
    }

    @Override
    public List<Photographer> createMany(List<PhotographerImportDto> photographerImportDtos) {
        List<Camera> cameras = this.cameraRepository.findAll();
        List<CameraIdAndMakeDto> cameraIdAndMakeDtos = this.mapperConverter.convertCamerasToCamerasDto(cameras, CameraIdAndMakeDto.class);

        for (PhotographerImportDto photographerImportDto : photographerImportDtos) {
            photographerImportDto.setPrimaryCamera(cameraIdAndMakeDtos.get(RandomNumber.getRandomNumber(cameraIdAndMakeDtos.size() - 1)));
            photographerImportDto.setSecondaryCamera(cameraIdAndMakeDtos.get(RandomNumber.getRandomNumber(cameraIdAndMakeDtos.size() - 1)));

            List<Lens> lens = this.lensRepository.getLensByIdIn(photographerImportDto.getLensesIds());
            List<LensIdAndCompatibleDto> lensIdAndCompatibleDtos = new ArrayList<>(Arrays.asList(this.mapperConverter.convert(lens, LensIdAndCompatibleDto[].class)));

            lensIdAndCompatibleDtos.removeIf(lensIdAndCompatibleDto -> !lensIdAndCompatibleDto.getCompatibleWith().equals(photographerImportDto.getPrimaryCamera().getMake()) && !lensIdAndCompatibleDto.getCompatibleWith().equals(photographerImportDto.getSecondaryCamera().getMake()));

            photographerImportDto.setLenses(new HashSet<>(lensIdAndCompatibleDtos));
        }

        List<Photographer> photographers = this.mapperConverter.convertPhotographersWithAbstractCameras(photographerImportDtos, Photographer[].class);
        List<Photographer> photographerList = new ArrayList<>();
        for (Photographer photographer : photographers) {
            if (DTOValidator.isValid(photographer)) {
                photographerList.add(this.photographerRepository.createOneWithLenses(photographer));
                this.writer.println(SUCCESSFULLY_IMPORTED_PHOTOGRAPHER, photographer.getFirstName(), photographer.getLastName(), photographer.getLenses().size());
            } else {
                this.writer.println(ERROR_INVALID_DATA_PROVIDED);
            }
        }
        return photographerList;
    }

    @Override
    public Photographer updateOne(Photographer photographer) {
        return this.photographerRepository.save(photographer);
    }

    @Override
    public List<Photographer> updateMany(Iterable<Photographer> photographers) {
        return this.photographerRepository.save(photographers);
    }

    @Override
    @Modifying
    public void deleteById(long id) {
        this.photographerRepository.delete(id);
    }

    @Override
    @Modifying
    public void deleteByPhotographer(Photographer photographer) {
        this.photographerRepository.delete(photographer);
    }

    @Override
    public List<PhotographerViewDto> getOrderedPhotographers() {
        List<Photographer> orderedPhotographers = this.photographerRepository.getPhotographersByOrderByFirstNameAscLastNameDesc();
        return Arrays.asList(this.mapperConverter.convert(orderedPhotographers, PhotographerViewDto[].class));
    }

    @Override
    public List<LandscapePhotographerViewDto> getLandscapePhotographers() {
        List<Photographer> photographers = this.photographerRepository.getPhotographersByPrimaryCamera();
        LandscapePhotographerViewDto[] landscapePhotographerViewDtosArray = this.mapperConverter.convert(photographers, LandscapePhotographerViewDto[].class);

        List<LandscapePhotographerViewDto> landscapePhotographerViewDtosList = new ArrayList<>(Arrays.asList(landscapePhotographerViewDtosArray));

        for (Iterator<LandscapePhotographerViewDto> landscapePhotographerViewDtoIterator = landscapePhotographerViewDtosList.iterator(); landscapePhotographerViewDtoIterator.hasNext();) {
            LandscapePhotographerViewDto next = landscapePhotographerViewDtoIterator.next();
            for (LensFocalLengthDto lensIdAndCompatibleDto : next.getLenses()) {
                if (lensIdAndCompatibleDto.getFocalLength() > 30) {
                    landscapePhotographerViewDtoIterator.remove();
                    break;
                }
            }
        }
        return landscapePhotographerViewDtosList;
    }

    @Override
    public PhotographersSameCamerasXmlViewDto getPhotographersWithSameCameras() {
        List<Photographer> sameCameras = this.photographerRepository.getPhotographerWithSameCameras();
        PhotographerSameCamerasXmlViewDto[] photographerSameCamerasXmlViewDtos = this.mapperConverter.convert(sameCameras, PhotographerSameCamerasXmlViewDto[].class);
        PhotographersSameCamerasXmlViewDto photographersSameCamerasXmlViewDto = new PhotographersSameCamerasXmlViewDto();
        photographersSameCamerasXmlViewDto.setPhotographerSameCamerasXmlViewDtos(Arrays.asList(photographerSameCamerasXmlViewDtos));
        return photographersSameCamerasXmlViewDto;
    }

}
