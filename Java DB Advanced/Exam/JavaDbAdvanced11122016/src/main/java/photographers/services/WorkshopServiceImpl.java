package photographers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import photographers.dtos.bindings.workshops.WorkshopImportDto;
import photographers.dtos.views.workshops.WorkshopByLocationXmlViewDto;
import photographers.dtos.views.workshops.WorkshopsByLocationXmlViewDto;
import photographers.entities.Photographer;
import photographers.entities.Workshop;
import photographers.io.Writer;
import photographers.repositories.PhotographerRepository;
import photographers.repositories.WorkshopRepository;
import photographers.utilities.MapperConverter;
import photographers.validators.DTOValidator;

import java.util.*;

import static photographers.constants.ErrorMessage.ERROR_INVALID_DATA_PROVIDED;

@Transactional
@Service
public class WorkshopServiceImpl implements WorkshopService {
    private static final String SUCCESSFULLY_IMPORTED_WORKSHOP_MESSAGE = "Successfully imported %s";

    private final WorkshopRepository workshopRepository;
    private final PhotographerRepository photographerRepository;
    private final MapperConverter mapperConverter;
    private final Writer writer;

    @Autowired
    public WorkshopServiceImpl(WorkshopRepository workshopRepository, PhotographerRepository photographerRepository, MapperConverter mapperConverter, Writer writer) {
        this.workshopRepository = workshopRepository;
        this.photographerRepository = photographerRepository;
        this.mapperConverter = mapperConverter;
        this.writer = writer;
    }

    @Override
    public List<Workshop> findAll() {
        return this.workshopRepository.findAll();
    }

    @Override
    public Workshop findById(long id) {
        return this.workshopRepository.findOne(id);
    }

    @Override
    public WorkshopsByLocationXmlViewDto getWorkshopByLocation() {
        List<Workshop> workshopByLocation = this.workshopRepository.getWorkshopByLocation();
        WorkshopByLocationXmlViewDto[] workshopByLocationXmlViewDtos = this.mapperConverter.convert(workshopByLocation, WorkshopByLocationXmlViewDto[].class);
        WorkshopsByLocationXmlViewDto workshopsByLocationXmlViewDto = new WorkshopsByLocationXmlViewDto();
        workshopsByLocationXmlViewDto.setWorkshopByLocationXmlViewDtos(Arrays.asList(workshopByLocationXmlViewDtos));
        return workshopsByLocationXmlViewDto;
    }

    @Override
    public Workshop createOne(Workshop workshop) {
        return this.workshopRepository.save(workshop);
    }

    @Override
    public List<Workshop> createMany(Iterable<WorkshopImportDto> workshopImportDtos) {
        List<Photographer> photographers = this.photographerRepository.findAll();

        Map<String, Photographer> photographerMap = new HashMap<>();
        for (Photographer photographer : photographers) {
            photographerMap.putIfAbsent(photographer.getFirstName() + " " + photographer.getLastName(), photographer);
        }

        Workshop[] workshopsArray = this.mapperConverter.convert(workshopImportDtos, Workshop[].class);

        List<Workshop> workshopList = new ArrayList<>(Arrays.asList(workshopsArray));

        for (Iterator<Workshop> workshopIterator = workshopList.iterator(); workshopIterator.hasNext(); ) {
            Workshop workshop = workshopIterator.next();
            workshop.setId(0);
            String trainerFullName = workshop.getTrainer().getFirstName() + " " + workshop.getTrainer().getLastName();
            if (photographerMap.containsKey(trainerFullName)) {
                workshop.setTrainer(photographerMap.get(trainerFullName));
            } else {
                workshopIterator.remove();
                continue;
            }

            if (workshop.getParticipants() != null) {
                for (Iterator<Photographer> photographerIterator = workshop.getParticipants().iterator(); photographerIterator.hasNext(); ) {
                    Photographer photographer = photographerIterator.next();
                    String fullName = photographer.getFirstName() + " " + photographer.getLastName();
                    if (photographerMap.containsKey(fullName)) {
                        Photographer photographer1 = photographerMap.get(fullName);
                        photographer.setId(photographer1.getId());
                        photographer.setPrimaryCamera(photographer1.getPrimaryCamera());
                        photographer.setSecondaryCamera(photographer1.getSecondaryCamera());
                    } else {
                        photographerIterator.remove();
                    }
                }
            }
        }

        List<Workshop> validWorkshops = new ArrayList<>();
        for (Workshop workshop : workshopList) {
            if (DTOValidator.isValid(workshop)) {
                Workshop one = this.workshopRepository.createOne(workshop);
                this.writer.println(SUCCESSFULLY_IMPORTED_WORKSHOP_MESSAGE, workshop.getName());
                validWorkshops.add(one);
            } else {
                this.writer.println(ERROR_INVALID_DATA_PROVIDED);
            }
        }
        return validWorkshops;
    }

    @Override
    public Workshop updateOne(Workshop workshop) {
        return this.workshopRepository.save(workshop);
    }

    @Override
    public List<Workshop> updateMany(Iterable<Workshop> workshops) {
        return this.workshopRepository.save(workshops);
    }

    @Override
    @Modifying
    public void deleteById(long id) {
        this.workshopRepository.delete(id);
    }

    @Override
    @Modifying
    public void deleteByWorkshop(Workshop workshop) {
        this.workshopRepository.delete(workshop);
    }

}
