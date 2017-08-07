package photography.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import photography.dtos.bindings.workshop.WorkshopImportFromXmlDto;
import photography.dtos.bindings.workshop.WorkshopParticipantImportDto;
import photography.dtos.views.worshop.WorkshopByLocationViewDto;
import photography.dtos.views.worshop.WorkshopsByLocationViewDto;
import photography.entities.Photographer;
import photography.entities.Workshop;
import photography.repositories.PhotographerRepository;
import photography.repositories.WorkshopRepository;
import photography.utilities.MapperConverter;
import photography.validators.DTOValidator;

import java.util.*;

@Transactional
@Service
public class WorkshopServiceImpl implements WorkshopService {

    private final WorkshopRepository workshopRepository;
    private final PhotographerRepository photographerRepository;
    private final MapperConverter mapperConverter;

    @Autowired
    public WorkshopServiceImpl(WorkshopRepository workshopRepository, PhotographerRepository photographerRepository, MapperConverter mapperConverter) {
        this.workshopRepository = workshopRepository;
        this.photographerRepository = photographerRepository;
        this.mapperConverter = mapperConverter;
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
    public Workshop createOne(WorkshopImportFromXmlDto workshopImportFromXmlDto) {
        Workshop workshop = this.mapperConverter.convert(workshopImportFromXmlDto, Workshop.class);
        List<Photographer> photographers = this.photographerRepository.findAll();
        Map<String, Photographer> photographerMap = convertListToMapOfPhotographers(photographers);

        Set<Photographer> participants = new HashSet<>();

        if (workshopImportFromXmlDto.getParticipants() != null) {
            for (WorkshopParticipantImportDto workshopParticipantImportDto : workshopImportFromXmlDto.getParticipants()) {
                participants.add(photographerMap.get(workshopParticipantImportDto.getFullName()));
            }
        }

        workshop.setTrainer(photographerMap.get(workshopImportFromXmlDto.getTrainer()));
        workshop.setParticipants(participants);

        if (DTOValidator.isValid(workshop)) {
            return this.workshopRepository.save(workshop);
        }
        return null;
    }

    @Override
    public List<Workshop> createMany(Iterable<Workshop> workshops) {
        return this.workshopRepository.save(workshops);
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

    @Override
    public WorkshopsByLocationViewDto getWorkshopsByLocation() {
        List<Workshop> workshops = this.workshopRepository.getWorkshopsByLocation();
        WorkshopByLocationViewDto[] workshopByLocationViewDtos = this.mapperConverter.convert(workshops, WorkshopByLocationViewDto[].class);
        WorkshopsByLocationViewDto workshopsByLocationViewDto = new WorkshopsByLocationViewDto();
        workshopsByLocationViewDto.setWorkshopByLocationViewDtos(Arrays.asList(workshopByLocationViewDtos));
        return workshopsByLocationViewDto;
    }


    private Map<String, Photographer> convertListToMapOfPhotographers(List<Photographer> photographers) {
        Map<String, Photographer> photographerMap = new HashMap<>();
        for (Photographer photographer : photographers) {
            photographerMap.putIfAbsent(photographer.getFirstName() + " " + photographer.getLastName(), photographer);
        }
        return photographerMap;
    }
}
