package wedding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import wedding.dtos.bindings.AgenciesImportFromJsonDto;
import wedding.dtos.views.agency.AgenciesOrderedJsonViewDto;
import wedding.dtos.views.agency.TownsAgenciesXmlViewDto;
import wedding.entities.Agency;
import wedding.io.Writer;
import wedding.serializers.Serializer;
import wedding.services.AgencyService;

import java.util.Arrays;
import java.util.List;

@Controller
public class AgencyController {
    private static final String AGENCIES_JSON_INPUT_PATH = "/json/input/agencies.json";
    private static final String AGENCIES_ORDERED_JSON_OUTPUT_PATH = "/src/main/resources/json/output/agencies-ordered.json";
    private static final String AGENCIES_BY_TOWN_XML_OUTPUT_PATH = "src/main/resources/xml/output/agencies-by-town.xml";
    private static final String SUCCESSFULLY_IMPORTED_AGENCY = "Successfully imported %s";

    private final Serializer jsonSerializer;
    private final Serializer xmlSerializer;
    private final AgencyService agencyService;
    private final Writer writer;

    @Autowired
    public AgencyController(@Qualifier("json") Serializer jsonSerializer, @Qualifier("xml") Serializer xmlSerializer, AgencyService agencyService, Writer writer) {
        this.jsonSerializer = jsonSerializer;
        this.xmlSerializer = xmlSerializer;
        this.agencyService = agencyService;
        this.writer = writer;
    }

    public void importAgenciesFromJson() {
        AgenciesImportFromJsonDto[] agenciesImportFromJsonDtos = this.jsonSerializer.deserialize(AgenciesImportFromJsonDto[].class, AGENCIES_JSON_INPUT_PATH);
        List<Agency> agencies = this.agencyService.createMany(Arrays.asList(agenciesImportFromJsonDtos));
        for (Agency agency : agencies) {
            this.writer.println(SUCCESSFULLY_IMPORTED_AGENCY, agency.getName());
        }
    }

    public void exportOrderedAgenciesToJson() {
        List<AgenciesOrderedJsonViewDto> orderedAgencies = this.agencyService.getOrderedAgencies();
        this.jsonSerializer.serialize(orderedAgencies, AGENCIES_ORDERED_JSON_OUTPUT_PATH);
    }

    public void getAgenciesByTown() {
        TownsAgenciesXmlViewDto townsAgenciesXmlViewDto = this.agencyService.getAgenciesByTown();
        this.xmlSerializer.serialize(townsAgenciesXmlViewDto, AGENCIES_BY_TOWN_XML_OUTPUT_PATH);
    }
}
