package photographers.services;

import photographers.dtos.bindings.workshops.WorkshopImportDto;
import photographers.dtos.views.workshops.WorkshopsByLocationXmlViewDto;
import photographers.entities.Workshop;

import java.util.List;

public interface WorkshopService {

    List<Workshop> findAll();

    Workshop findById(long id);

    WorkshopsByLocationXmlViewDto getWorkshopByLocation();

    Workshop createOne(Workshop workshop);

    List<Workshop> createMany(Iterable<WorkshopImportDto> workshopImportDtos);

    Workshop updateOne(Workshop workshop);

    List<Workshop> updateMany(Iterable<Workshop> workshops);

    void deleteById(long id);

    void deleteByWorkshop(Workshop workshop);
}
