package wedding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import wedding.dtos.bindings.WeddingsImportFromJsonDto;
import wedding.dtos.views.WeddingGuestListJsonViewDto;
import wedding.entities.Wedding;
import wedding.io.Writer;
import wedding.serializers.Serializer;
import wedding.services.WeddingService;
import wedding.utilities.MessagesConstants;

import java.util.Comparator;
import java.util.List;

@Controller
public class WeddingController {
    private static final String WEDDINGS_JSON_INPUT_PATH = "/json/input/weddings.json";
    private static final String WEDDINGS_GUEST_LIST_JSON_OUTPUT_PATH = "/src/main/resources/json/output/guests.json";
    private static final String SUCCESSFULLY_IMPORTED_WEDDING = "Successfully imported wedding of %s and %s";

    private final Serializer jsonSerializer;
    private final WeddingService weddingService;
    private final Writer writer;

    @Autowired
    public WeddingController(@Qualifier("json") Serializer jsonSerializer, WeddingService weddingService, Writer writer) {
        this.jsonSerializer = jsonSerializer;
        this.weddingService = weddingService;
        this.writer = writer;
    }

    public void importWeddingsFromJson() {
        WeddingsImportFromJsonDto[] weddingsImportFromJsonDtos = this.jsonSerializer.deserialize(WeddingsImportFromJsonDto[].class, WEDDINGS_JSON_INPUT_PATH);
        for (WeddingsImportFromJsonDto weddingsImportFromJsonDto : weddingsImportFromJsonDtos) {
            Wedding wedding = this.weddingService.createOne(weddingsImportFromJsonDto);
            if (wedding != null) {
                this.writer.println(SUCCESSFULLY_IMPORTED_WEDDING, wedding.getBride().getFirstName(), wedding.getBridegroom().getFirstName());
            } else {
                this.writer.println(MessagesConstants.INVALID_INPUT_DATA_MESSAGE);
            }
        }
    }

    public void exportWeddingsGuestList() {
        List<WeddingGuestListJsonViewDto> weddingsGuestList = this.weddingService.getWeddingsGuestList();
        weddingsGuestList.sort(Comparator.comparing(WeddingGuestListJsonViewDto::getInvitedGuests).reversed().thenComparing(WeddingGuestListJsonViewDto::getAttendingGuests));
        this.jsonSerializer.serialize(weddingsGuestList, WEDDINGS_GUEST_LIST_JSON_OUTPUT_PATH);
    }
}
