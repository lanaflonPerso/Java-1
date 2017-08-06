package photographers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import photographers.dtos.bindings.PhotographerImportDto;
import photographers.dtos.views.photographers.LandscapePhotographerViewDto;
import photographers.dtos.views.photographers.PhotographerViewDto;
import photographers.dtos.views.photographers.PhotographersSameCamerasXmlViewDto;
import photographers.serializers.Serializer;
import photographers.services.PhotographerService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Hristo Skipernov on 03/08/2017.
 */

@Controller
public class PhotographerController {
    private static final String PHOTOGRAPHERS_INPUT_JSON_PATH = "/jsons/input/photographers.json";
    private static final String PHOTOGRAPHERS_ORDERED_JSON_PATH = "/src/main/resources/jsons/output/photographers-ordered.json";
    private static final String LANDSCAPE_PHOTOGRAPHERS_JSON_PATH = "/src/main/resources/jsons/output/landscape-photogaphers.json";
    private static final String SAME_CAMERAS_PHOTOGRAPHERS_XML_PATH = "src/main/resources/xmls/output/same-cameras-photographers.xml";

    private final Serializer jsonSerializer;
    private final Serializer xmlSerializer;
    private final PhotographerService photographerService;

    @Autowired
    public PhotographerController(@Qualifier("json") Serializer jsonSerializer, @Qualifier("xml") Serializer xmlSerializer, PhotographerService photographerService) {
        this.xmlSerializer = xmlSerializer;
        this.photographerService = photographerService;
        this.jsonSerializer = jsonSerializer;
    }

    public void importPhotographers() {
        PhotographerImportDto[] photographerImportDtos = this.jsonSerializer.deserialize(PhotographerImportDto[].class, PHOTOGRAPHERS_INPUT_JSON_PATH);
        this.photographerService.createMany(Arrays.asList(photographerImportDtos));
    }

    public void exportOrderedPhotographers() {
        List<PhotographerViewDto> orderedPhotographers = this.photographerService.getOrderedPhotographers();
        this.jsonSerializer.serialize(orderedPhotographers, PHOTOGRAPHERS_ORDERED_JSON_PATH);
    }

    public void exportLandscapePhotographers() {
        List<LandscapePhotographerViewDto> landscapePhotographerViewDtos = this.photographerService.getLandscapePhotographers();
        this.jsonSerializer.serialize(landscapePhotographerViewDtos, LANDSCAPE_PHOTOGRAPHERS_JSON_PATH);
    }

    public void exportSameCamerasPhotographers() {
        PhotographersSameCamerasXmlViewDto photographersSameCamerasXmlViewDtos = this.photographerService.getPhotographersWithSameCameras();
        this.xmlSerializer.serialize(photographersSameCamerasXmlViewDtos, SAME_CAMERAS_PHOTOGRAPHERS_XML_PATH);
    }
}
