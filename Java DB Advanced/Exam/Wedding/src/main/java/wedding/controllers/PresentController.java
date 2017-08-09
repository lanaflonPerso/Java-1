package wedding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import wedding.dtos.bindings.present.PresentImportFromXmlDto;
import wedding.dtos.bindings.present.PresentsImportFromXmlDto;
import wedding.entities.Present;
import wedding.io.Writer;
import wedding.serializers.Serializer;
import wedding.services.PresentService;
import wedding.utilities.MessagesConstants;

@Controller
public class PresentController {
    private static final String PRESENT_XML_INPUT_PATH = "/xml/input/presents.xml";
    private static final String SUCCESSFULLY_IMPORTED_PRESENT = "Succesfully imported gift from %s";

    private final Serializer xmlSerializer;
    private final PresentService presentService;
    private final Writer writer;

    @Autowired
    public PresentController(@Qualifier("xml") Serializer xmlSerializer, PresentService presentService, Writer writer) {
        this.xmlSerializer = xmlSerializer;
        this.presentService = presentService;
        this.writer = writer;
    }

    public void importPresentsFromXml() {
        PresentsImportFromXmlDto presentsImportFromXmlDto = this.xmlSerializer.deserialize(PresentsImportFromXmlDto.class, PRESENT_XML_INPUT_PATH);
        for (PresentImportFromXmlDto presentImportFromXmlDto : presentsImportFromXmlDto.getPresentImportFromXmlDtos()) {
            Present present = this.presentService.createOne(presentImportFromXmlDto);
            if (present != null) {
                this.writer.println(SUCCESSFULLY_IMPORTED_PRESENT, present.getOwner().getFullName());
            } else {
                this.writer.println(MessagesConstants.INVALID_INPUT_DATA_MESSAGE);
            }
        }
    }
}
