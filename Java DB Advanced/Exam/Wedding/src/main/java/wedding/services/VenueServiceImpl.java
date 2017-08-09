package wedding.services;

import wedding.dtos.bindings.venue.VenueImportFromXmlDto;
import wedding.dtos.views.venue.VenueInSofiaXmlViewDto;
import wedding.dtos.views.venue.VenuesInSofiaXmlViewDto;
import wedding.entities.Venue;
import wedding.repositories.VenueRepository;
import wedding.utilities.MapperConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Transactional
@Service
public class VenueServiceImpl implements VenueService {

    private final VenueRepository venueRepository;
    private final MapperConverter mapperConverter;

    @Autowired
    public VenueServiceImpl(VenueRepository venueRepository, MapperConverter mapperConverter) {
        this.venueRepository = venueRepository;
        this.mapperConverter = mapperConverter;
    }

    @Override
    public Venue createOne(Venue venue) {
        return this.venueRepository.save(venue);
    }

    @Override
    public List<Venue> createMany(List<VenueImportFromXmlDto> venueImportFromXmlDtos) {
        Venue[] venues = this.mapperConverter.convert(venueImportFromXmlDtos, Venue[].class);
        return this.venueRepository.save(Arrays.asList(venues));
    }

    @Override
    public VenuesInSofiaXmlViewDto getVenuesInSofia() {
        List<Venue> venuesInSofia = this.venueRepository.getVenuesInSofia();
        VenueInSofiaXmlViewDto[] venueImportFromXmlDtos = this.mapperConverter.convert(venuesInSofia, VenueInSofiaXmlViewDto[].class);
        VenuesInSofiaXmlViewDto venuesInSofiaXmlViewDto = new VenuesInSofiaXmlViewDto();
        venuesInSofiaXmlViewDto.setVenueInSofiaXmlViewDtos(Arrays.asList(venueImportFromXmlDtos));
        return venuesInSofiaXmlViewDto;
    }

}
