package wedding.services;

import wedding.dtos.bindings.venue.VenueImportFromXmlDto;
import wedding.dtos.views.venue.VenuesInSofiaXmlViewDto;
import wedding.entities.Venue;

import java.util.List;

public interface VenueService {

    Venue createOne(Venue venue);

    List<Venue> createMany(List<VenueImportFromXmlDto> venueImportFromXmlDtos);

    VenuesInSofiaXmlViewDto getVenuesInSofia();
}
