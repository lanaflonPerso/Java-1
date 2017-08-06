package photographers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import photographers.dtos.bindings.workshops.WorkshopsImportDto;
import photographers.dtos.views.workshops.WorkshopsByLocationXmlViewDto;
import photographers.serializers.Serializer;
import photographers.services.WorkshopService;

@Controller
public class WorkshopController {
    private static final String WORKSHOPS_INPUT_XML_PATH = "/xmls/input/workshops.xml";
    private static final String WORKSHOPS_BY_LOCATIONS_OUTPUT_XML_PATH = "src/main/resources/xmls/output/workshops-by-location.xml";

    private final Serializer xmlSerializer;
    private final WorkshopService workshopService;

    @Autowired
    public WorkshopController(@Qualifier("xml") Serializer xmlSerializer, WorkshopService workshopService) {
        this.workshopService = workshopService;
        this.xmlSerializer = xmlSerializer;
    }

    public void importWorkshops() {
        WorkshopsImportDto workshopsImportDto = this.xmlSerializer.deserialize(WorkshopsImportDto.class, WORKSHOPS_INPUT_XML_PATH);
        this.workshopService.createMany(workshopsImportDto.getWorkshopImportDtos());
    }

    public void exportWorkshopsByLocations() {
        WorkshopsByLocationXmlViewDto workshopByLocation = this.workshopService.getWorkshopByLocation();
        this.xmlSerializer.serialize(workshopByLocation, WORKSHOPS_BY_LOCATIONS_OUTPUT_XML_PATH);
    }
}
