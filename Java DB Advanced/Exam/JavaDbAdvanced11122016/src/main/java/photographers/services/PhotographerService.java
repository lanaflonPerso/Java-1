package photographers.services;

import photographers.dtos.bindings.PhotographerImportDto;
import photographers.dtos.views.photographers.LandscapePhotographerViewDto;
import photographers.dtos.views.photographers.PhotographerViewDto;
import photographers.dtos.views.photographers.PhotographersSameCamerasXmlViewDto;
import photographers.entities.Photographer;

import java.util.List;

public interface PhotographerService {

    List<Photographer> findAll();

    Photographer findById(long id);

    Photographer createOne(Photographer photographer);

    List<Photographer> createMany(List<PhotographerImportDto> photographerImportDtos);

    Photographer updateOne(Photographer photographer);

    List<Photographer> updateMany(Iterable<Photographer> photographers);

    void deleteById(long id);

    void deleteByPhotographer(Photographer photographer);

    List<PhotographerViewDto> getOrderedPhotographers();

    List<LandscapePhotographerViewDto> getLandscapePhotographers();

    PhotographersSameCamerasXmlViewDto getPhotographersWithSameCameras();
}
