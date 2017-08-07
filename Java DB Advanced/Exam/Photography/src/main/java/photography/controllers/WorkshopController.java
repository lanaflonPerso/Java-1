package photography.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import photography.constants.MessageConstants;
import photography.dtos.bindings.workshop.WorkshopImportFromXmlDto;
import photography.dtos.bindings.workshop.WorkshopsImportFromXmlDto;
import photography.dtos.views.worshop.WorkshopsByLocationViewDto;
import photography.entities.Workshop;
import photography.io.Writer;
import photography.serializers.Serializer;
import photography.services.WorkshopService;

@Controller
public class WorkshopController {
    private static final String SUCCESSFULLY_IMPORTED_WORKSHOP_MESSAGE = "Successfully imported %s";
    private static final String WORKSHOPS_XML_INPUT_PATH = "/xmls/input/workshops.xml";
    private static final String WORKSHOPS_BY_LOCATION_XML_OUTPUT_PATH = "src/main/resources/xmls/output/workshops-by-location.xml ";

    private final Serializer jsonSerializer;
    private final Serializer xmlSerializer;
    private final WorkshopService workshopService;
    private final Writer writer;

    @Autowired
    public WorkshopController(@Qualifier("json") Serializer jsonSerializer, @Qualifier("xml") Serializer xmlSerializer, WorkshopService workshopService, Writer writer) {
        this.jsonSerializer = jsonSerializer;
        this.xmlSerializer = xmlSerializer;
        this.workshopService = workshopService;
        this.writer = writer;
    }

    public void importWorkshops() {
        WorkshopsImportFromXmlDto workshopsImportFromXmlDto = this.xmlSerializer.deserialize(WorkshopsImportFromXmlDto.class, WORKSHOPS_XML_INPUT_PATH);
        for (WorkshopImportFromXmlDto workshopImportFromXmlDto : workshopsImportFromXmlDto.getWorkshopImportFromXmlDtos()) {
            Workshop workshop = this.workshopService.createOne(workshopImportFromXmlDto);
            if (workshop != null) {
                this.writer.println(SUCCESSFULLY_IMPORTED_WORKSHOP_MESSAGE, workshop.getName());
            } else {
                this.writer.println(MessageConstants.INVALID_INPUT_DATA_MESSAGE);
            }
        }
    }

    public void exportWorkshopsByLocation() {
        WorkshopsByLocationViewDto workshopsByLocationViewDto = this.workshopService.getWorkshopsByLocation();
        this.xmlSerializer.serialize(workshopsByLocationViewDto, WORKSHOPS_BY_LOCATION_XML_OUTPUT_PATH);
    }
}
