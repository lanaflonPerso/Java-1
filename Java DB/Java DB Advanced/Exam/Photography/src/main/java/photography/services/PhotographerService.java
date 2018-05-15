package photography.services;

import photography.dtos.bindings.PhotographerImportFromJsonDto;
import photography.dtos.views.photographer.PhotographerLandscapeViewDto;
import photography.dtos.views.photographer.PhotographerOrderedViewDto;
import photography.dtos.views.photographer.PhotographersSameCamerasViewDto;
import photography.entities.Photographer;

import java.util.List;

public interface PhotographerService {

    List<Photographer> findAll();

    Photographer findById(long id);

    Photographer createOne(PhotographerImportFromJsonDto photographerImportFromJsonDto);

    List<Photographer> createMany(Iterable<Photographer> photographer);

    Photographer updateOne(Photographer photographer);

    List<Photographer> updateMany(Iterable<Photographer> photographers);

    void deleteById(long id);

    void deleteByPhotographer(Photographer photographer);

    List<PhotographerOrderedViewDto> getOrderedPhotographers();

    List<PhotographerLandscapeViewDto> getLandscapePhotographers();

    PhotographersSameCamerasViewDto getSameCamerasPhotographers();
}
