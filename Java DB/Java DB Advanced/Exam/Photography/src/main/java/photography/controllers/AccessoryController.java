package photography.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import photography.dtos.bindings.accessory.AccessoriesImportFromXmlDto;
import photography.entities.Accessory;
import photography.io.Writer;
import photography.serializers.Serializer;
import photography.services.AccessoryService;

import java.util.List;

@Controller
public class AccessoryController {
    private static final String ACCESSORIES_XMLS_INPUT_PATH = "/xmls/input/accessories.xml";
    private static final String SUCCESSFULLY_IMPORTED_ACCESSORY_MESSAGE = "Successfully imported %s";

    private final Serializer jsonSerializer;
    private final Serializer xmlSerializer;
    private final AccessoryService accessoryService;
    private final Writer writer;

    @Autowired
    public AccessoryController(@Qualifier("json") Serializer jsonSerializer, @Qualifier("xml") Serializer xmlSerializer, AccessoryService accessoryService, Writer writer) {
        this.jsonSerializer = jsonSerializer;
        this.xmlSerializer = xmlSerializer;
        this.accessoryService = accessoryService;
        this.writer = writer;
    }


    public void importAccesories() {
        AccessoriesImportFromXmlDto accessoriesImportFromXmlDto = this.xmlSerializer.deserialize(AccessoriesImportFromXmlDto.class, ACCESSORIES_XMLS_INPUT_PATH);
        List<Accessory> accessories = this.accessoryService.createMany(accessoriesImportFromXmlDto.getAccessoryImportFromXmlDtos());
        for (Accessory accessory : accessories) {
            this.writer.println(SUCCESSFULLY_IMPORTED_ACCESSORY_MESSAGE, accessory.getName());
        }
    }
}
