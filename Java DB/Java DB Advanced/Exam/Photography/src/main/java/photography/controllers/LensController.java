package photography.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import photography.dtos.bindings.LensImportFromJsonDto;
import photography.entities.Lens;
import photography.io.Writer;
import photography.serializers.Serializer;
import photography.services.LensService;

import java.util.Arrays;
import java.util.List;

@Controller
public class LensController {
    private static final String SUCCESSFULLY_IMPORTED_LENS_MESSAGE = "Successfully imported %s %dmm f%.1f";
    private static final String LENSES_JSON_INPUT_PATH = "/jsons/input/lenses.json";

    private final Serializer jsonSerializer;
    private final Serializer xmlSerializer;
    private final LensService lensService;
    private final Writer writer;

    @Autowired
    public LensController(@Qualifier("json") Serializer jsonSerializer, @Qualifier("xml") Serializer xmlSerializer, LensService lensService, Writer writer) {
        this.jsonSerializer = jsonSerializer;
        this.xmlSerializer = xmlSerializer;
        this.lensService = lensService;
        this.writer = writer;
    }

    public void importLenses() {
        LensImportFromJsonDto[] lensImportFromJsonDtos = this.jsonSerializer.deserialize(LensImportFromJsonDto[].class, LENSES_JSON_INPUT_PATH);
        List<Lens> lenses = this.lensService.createMany(Arrays.asList(lensImportFromJsonDtos));
        for (Lens lens : lenses) {
            this.writer.println(SUCCESSFULLY_IMPORTED_LENS_MESSAGE, lens.getMake(), lens.getFocalLength(), lens.getMaxAperture());
        }
    }
}
