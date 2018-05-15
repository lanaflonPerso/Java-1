package wedding.services;

import wedding.dtos.bindings.AgenciesImportFromJsonDto;
import wedding.dtos.views.agency.AgenciesOrderedJsonViewDto;
import wedding.dtos.views.agency.TownsAgenciesXmlViewDto;
import wedding.entities.Agency;

import java.util.List;

public interface AgencyService {

    Agency createOne(Agency agency);

    List<Agency> createMany(Iterable<AgenciesImportFromJsonDto> agencyImportFromJsonDtos);

    List<AgenciesOrderedJsonViewDto> getOrderedAgencies();

    TownsAgenciesXmlViewDto getAgenciesByTown();
}
