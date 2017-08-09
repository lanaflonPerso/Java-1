package wedding.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wedding.dtos.bindings.WeddingsImportFromJsonDto;
import wedding.dtos.views.WeddingGuestListJsonViewDto;
import wedding.entities.*;
import wedding.repositories.AgencyRepository;
import wedding.repositories.PersonRepository;
import wedding.repositories.VenueRepository;
import wedding.repositories.WeddingRepository;
import wedding.utilities.MapperConverter;
import wedding.utilities.RandomNumber;
import wedding.validators.DTOValidator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class WeddingServiceImpl implements WeddingService {

    private final WeddingRepository weddingRepository;
    private final PersonRepository personRepository;
    private final AgencyRepository agencyRepository;
    private final VenueRepository venueRepository;
    private final MapperConverter mapperConverter;

    @Autowired
    public WeddingServiceImpl(WeddingRepository weddingRepository, PersonRepository personRepository, AgencyRepository agencyRepository, VenueRepository venueRepository, MapperConverter mapperConverter) {
        this.weddingRepository = weddingRepository;
        this.personRepository = personRepository;
        this.agencyRepository = agencyRepository;
        this.venueRepository = venueRepository;
        this.mapperConverter = mapperConverter;
    }

    @Override
    public Wedding createOne(WeddingsImportFromJsonDto weddingsImportFromJsonDto) {
        Wedding wedding = this.mapperConverter.convert(weddingsImportFromJsonDto, Wedding.class);

        if (wedding.getBride() != null) {
            wedding.setBride(this.personRepository.getPersonByFirstNameAndMiddleNameInitialAndLastName(wedding.getBride().getFirstName(), wedding.getBride().getMiddleNameInitial(), wedding.getBride().getLastName()));
        }
        if (wedding.getBridegroom() != null) {
            wedding.setBridegroom(this.personRepository.getPersonByFirstNameAndMiddleNameInitialAndLastName(wedding.getBridegroom().getFirstName(), wedding.getBridegroom().getMiddleNameInitial(), wedding.getBridegroom().getLastName()));
        }

        List<Agency> agencies = this.agencyRepository.getAgencyByName(wedding.getAgency().getName());
        if (!agencies.isEmpty()) {
            wedding.setAgency(agencies.get(0));
        }

        Set<Invitation> validInvitations = new HashSet<>();
        if (wedding.getInvitations() != null) {
            for (Invitation invitation : wedding.getInvitations()) {
                Person person = this.personRepository.getPersonByFirstNameAndMiddleNameInitialAndLastName(invitation.getGuest().getFirstName(), invitation.getGuest().getMiddleNameInitial(), invitation.getGuest().getLastName());
                if (person != null) {
                    invitation.setGuest(person);
                    invitation.setWedding(wedding);
                    validInvitations.add(invitation);
                }
            }
        }
        wedding.setInvitations(validInvitations);

        if (DTOValidator.isValid(wedding)) {
            return this.weddingRepository.save(wedding);
        }
        return null;
    }


    @Override
    public List<Wedding> createMany(Iterable<Wedding> weddings) {
        return this.weddingRepository.save(weddings);
    }

    @Override
    public List<WeddingGuestListJsonViewDto> getWeddingsGuestList() {
        List<Wedding> weddings = this.weddingRepository.findAll();
        WeddingGuestListJsonViewDto[] weddingGuestListJsonViewDtos = this.mapperConverter.convert(weddings, WeddingGuestListJsonViewDto[].class);
        return Arrays.asList(weddingGuestListJsonViewDtos);
    }

    @Override
    public void addVenues() {
        long venuesCount = this.venueRepository.count();
        List<Wedding> weddings = this.weddingRepository.findAll();

        for (Wedding wedding : weddings) {
            Set<Venue> venues = new HashSet<>();
            long random1 = RandomNumber.getRandomNumber(1, venuesCount);
            long random2 = RandomNumber.getRandomNumber(1, venuesCount);
            while (random1 == random2) {
                random2 = RandomNumber.getRandomNumber(1, venuesCount);
            }
            venues.add(this.venueRepository.findOne(random1));
            venues.add(this.venueRepository.findOne(random2));
            wedding.setVenues(venues);
        }
    }

}
