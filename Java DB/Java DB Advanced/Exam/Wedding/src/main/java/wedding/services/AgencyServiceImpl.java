package wedding.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wedding.dtos.bindings.AgenciesImportFromJsonDto;
import wedding.dtos.views.InvitationInfoWithPresentXmlViewDto;
import wedding.dtos.views.WeddingInfoXmlViewDto;
import wedding.dtos.views.agency.*;
import wedding.entities.Agency;
import wedding.repositories.AgencyRepository;
import wedding.repositories.PresentRepository;
import wedding.utilities.MapperConverter;

import java.util.*;

@Transactional
@Service
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository agencyRepository;
    private final PresentRepository presentRepository;
    private final MapperConverter mapperConverter;

    @Autowired
    public AgencyServiceImpl(AgencyRepository agencyRepository, PresentRepository presentRepository, MapperConverter mapperConverter) {
        this.agencyRepository = agencyRepository;
        this.presentRepository = presentRepository;
        this.mapperConverter = mapperConverter;
    }

    @Override
    public Agency createOne(Agency agency) {
        return this.agencyRepository.save(agency);
    }

    @Override
    public List<Agency> createMany(Iterable<AgenciesImportFromJsonDto> agencyImportFromJsonDtos) {
        Agency[] agencies = this.mapperConverter.convert(agencyImportFromJsonDtos, Agency[].class);
        return this.agencyRepository.save(Arrays.asList(agencies));
    }

    @Override
    public List<AgenciesOrderedJsonViewDto> getOrderedAgencies() {
        List<Agency> agencies = this.agencyRepository.getAgenciesByOrderByEmployeesCountDesc();
        AgenciesOrderedJsonViewDto[] agenciesOrderedJsonViewDtos = this.mapperConverter.convert(agencies, AgenciesOrderedJsonViewDto[].class);
        return Arrays.asList(agenciesOrderedJsonViewDtos);
    }

    @Override
    public TownsAgenciesXmlViewDto getAgenciesByTown() {
        List<Agency> agencies = this.agencyRepository.getAgenciesByTown();

        Map<String, List<Agency>> agencyMap = new HashMap<>();
        for (Agency agency : agencies) {
            List<Agency> agencyList = new ArrayList<>();
            if (agencyMap.containsKey(agency.getTown())) {
                agencyList = agencyMap.get(agency.getTown());
            }
            agencyList.add(agency);
            agencyMap.putIfAbsent(agency.getTown(), agencyList);
        }

        List<TownAgenciesXmlViewDto> townAgenciesXmlViewDtos = new ArrayList<>();
        for (Map.Entry<String, List<Agency>> stringListEntry : agencyMap.entrySet()) {
            TownAgenciesXmlViewDto townAgenciesXmlViewDto = new TownAgenciesXmlViewDto();
            townAgenciesXmlViewDto.setName(stringListEntry.getKey());
            AgencyInfoXmlViewDto[] agencyInfoXmlViewDto = this.mapperConverter.convert(stringListEntry.getValue(), AgencyInfoXmlViewDto[].class);
            for (AgencyInfoXmlViewDto infoXmlViewDto : agencyInfoXmlViewDto) {
                for (WeddingInfoXmlViewDto weddingInfoXmlViewDto : infoXmlViewDto.getWeddings()) {
                    for (InvitationInfoWithPresentXmlViewDto invitationInfoWithPresentXmlViewDto : weddingInfoXmlViewDto.getInvitations()) {
                        if (invitationInfoWithPresentXmlViewDto.getPresent() == null) {
                            continue;
                        }
                        long id = invitationInfoWithPresentXmlViewDto.getPresent().getId();
                        invitationInfoWithPresentXmlViewDto.getPresent().setCashAmount(this.presentRepository.getPresentCashAmount(id));
                        invitationInfoWithPresentXmlViewDto.getPresent().setName(this.presentRepository.getPresentName(id));
                        invitationInfoWithPresentXmlViewDto.getPresent().setSize(this.presentRepository.getPresentSize(id));
                    }
                }
            }
            AgenciesInfoXmlViewDto agenciesInfoXmlViewDto = new AgenciesInfoXmlViewDto();
            agenciesInfoXmlViewDto.setAgencyInfoXmlViewDtos(Arrays.asList(agencyInfoXmlViewDto));
            townAgenciesXmlViewDto.setAgencies(agenciesInfoXmlViewDto);
            townAgenciesXmlViewDtos.add(townAgenciesXmlViewDto);
        }

        TownsAgenciesXmlViewDto townsAgenciesXmlViewDto = new TownsAgenciesXmlViewDto();
        townsAgenciesXmlViewDto.setTownAgenciesXmlViewDtos(townAgenciesXmlViewDtos);

        return townsAgenciesXmlViewDto;
    }

}
