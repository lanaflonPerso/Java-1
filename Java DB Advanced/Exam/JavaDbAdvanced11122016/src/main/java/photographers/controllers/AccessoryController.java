package photographers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import photographers.dtos.bindings.accessories.AccessoriesImportXmlDto;
import photographers.serializers.Serializer;
import photographers.services.AccessoryService;

@Controller
public class AccessoryController {
    private static final String ACCESSORIES_INPUT_XML_PATH = "/xmls/input/accessories.xml";

    private final Serializer xmlSerializer;
    private final AccessoryService accessoryService;

    @Autowired
    public AccessoryController(@Qualifier("xml") Serializer xmlSerializer, AccessoryService accessoryService) {
        this.accessoryService = accessoryService;
        this.xmlSerializer = xmlSerializer;
    }

    public void importAccessories() {
        AccessoriesImportXmlDto accessoriesImportXmlDto = this.xmlSerializer.deserialize(AccessoriesImportXmlDto.class, ACCESSORIES_INPUT_XML_PATH);
        this.accessoryService.createMany(accessoriesImportXmlDto.getAccessoryImportDtos());
    }
}
