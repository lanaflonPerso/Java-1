package photographers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import photographers.dtos.bindings.LensImportDto;
import photographers.serializers.Serializer;
import photographers.services.LensService;

import java.util.Arrays;

/**
 * Created by Hristo Skipernov on 03/08/2017.
 */

@Controller
public class LensController {
    private static final String LENSES_INPUT_JSON_PATH = "/jsons/input/lenses.json";

    private final Serializer jsonSerializer;
    private final LensService lensService;

    @Autowired
    public LensController(LensService lensService, @Qualifier("json") Serializer jsonSerializer) {
        this.lensService = lensService;
        this.jsonSerializer = jsonSerializer;
    }

    public void importLenses() {
        LensImportDto[] lensImportDtos = this.jsonSerializer.deserialize(LensImportDto[].class, LENSES_INPUT_JSON_PATH);
        this.lensService.createMany(Arrays.asList(lensImportDtos));
    }
}
