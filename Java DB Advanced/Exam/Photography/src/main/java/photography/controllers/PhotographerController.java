package photography.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import photography.constants.MessageConstants;
import photography.dtos.bindings.PhotographerImportFromJsonDto;
import photography.dtos.views.photographer.PhotographerLandscapeViewDto;
import photography.dtos.views.photographer.PhotographerOrderedViewDto;
import photography.dtos.views.photographer.PhotographersSameCamerasViewDto;
import photography.entities.Photographer;
import photography.io.Writer;
import photography.serializers.Serializer;
import photography.services.LensService;
import photography.services.PhotographerService;

import java.util.List;

@Controller
public class PhotographerController {
    private static final String SUCCESSFULLY_IMPORTED_PHOTOGRAPHER_MESSAGE = "Successfully imported %s %s | Lenses: %d";
    private static final String PHOTOGRAPHERS_JSON_INPUT_PATH = "/jsons/input/photographers.json";
    private static final String PHOTOGRAPHERS_ORDERED_JSON_OUTPUT_PATH = "/src/main/resources/jsons/output/photographers-ordered.json";
    private static final String PHOTOGRAPHERS_LANDSCAPE_JSON_OUTPUT_PATH = "/src/main/resources/jsons/output/landscape-photogaphers.json";
    private static final String PHOTOGRAPHERS_SAME_CAMERAS_XML_OUTPUT_PATH = "src/main/resources/xmls/output/same-cameras-photographers.xml";

    private final Serializer jsonSerializer;
    private final Serializer xmlSerializer;
    private final PhotographerService photographerService;
    private final LensService lensService;
    private final Writer writer;

    @Autowired
    public PhotographerController(@Qualifier("json") Serializer jsonSerializer, @Qualifier("xml") Serializer xmlSerializer, PhotographerService photographerService, LensService lensService, Writer writer) {
        this.jsonSerializer = jsonSerializer;
        this.xmlSerializer = xmlSerializer;
        this.photographerService = photographerService;
        this.lensService = lensService;
        this.writer = writer;
    }

    public void importPhotographers() {
        PhotographerImportFromJsonDto[] photographerImportFromJsonDtos = this.jsonSerializer.deserialize(PhotographerImportFromJsonDto[].class, PHOTOGRAPHERS_JSON_INPUT_PATH);
        for (PhotographerImportFromJsonDto photographerImportFromJsonDto : photographerImportFromJsonDtos) {
            Photographer photographer = this.photographerService.createOne(photographerImportFromJsonDto);
            if (photographer != null) {
                this.writer.println(SUCCESSFULLY_IMPORTED_PHOTOGRAPHER_MESSAGE, photographer.getFirstName(), photographer.getLastName(), this.lensService.countByLensOwnerId(photographer.getId()));
            } else {
                this.writer.println(MessageConstants.INVALID_INPUT_DATA_MESSAGE);
            }
        }
    }

    public void exportOrderedPhotographers() {
        List<PhotographerOrderedViewDto> photographerOrderedViewDtos = this.photographerService.getOrderedPhotographers();
        this.jsonSerializer.serialize(photographerOrderedViewDtos, PHOTOGRAPHERS_ORDERED_JSON_OUTPUT_PATH);
    }

    public void exportLandscapePhotographers() {
        List<PhotographerLandscapeViewDto> photographerLandscapeViewDtos = this.photographerService.getLandscapePhotographers();
        this.jsonSerializer.serialize(photographerLandscapeViewDtos, PHOTOGRAPHERS_LANDSCAPE_JSON_OUTPUT_PATH);
    }

    public void exportSameCamerasPhotographers() {
        PhotographersSameCamerasViewDto photographerSameCamerasViewDtos = this.photographerService.getSameCamerasPhotographers();
        this.xmlSerializer.serialize(photographerSameCamerasViewDtos, PHOTOGRAPHERS_SAME_CAMERAS_XML_OUTPUT_PATH);
    }
}
