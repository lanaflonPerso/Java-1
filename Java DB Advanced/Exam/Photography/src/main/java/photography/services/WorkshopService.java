package photography.services;

import photography.dtos.bindings.workshop.WorkshopImportFromXmlDto;
import photography.dtos.views.worshop.WorkshopsByLocationViewDto;
import photography.entities.Workshop;

import java.util.List;

public interface WorkshopService {

    List<Workshop> findAll();

    Workshop findById(long id);

    Workshop createOne(WorkshopImportFromXmlDto workshopImportFromXmlDto);

    List<Workshop> createMany(Iterable<Workshop> workshops);

    Workshop updateOne(Workshop workshop);

    List<Workshop> updateMany(Iterable<Workshop> workshops);

    void deleteById(long id);

    void deleteByWorkshop(Workshop workshop);

    WorkshopsByLocationViewDto getWorkshopsByLocation();
}
