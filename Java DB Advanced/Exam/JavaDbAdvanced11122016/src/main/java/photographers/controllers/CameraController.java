package photographers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import photographers.dtos.bindings.CameraImportDto;
import photographers.serializers.Serializer;
import photographers.services.CameraService;

import java.util.Arrays;

/**
 * Created by Hristo Skipernov on 03/08/2017.
 */

@Controller
public class CameraController {
    private static final String CAMERAS_INPUT_JSON_PATH = "/jsons/input/cameras.json";

    private final Serializer jsonSerializer;
    private final CameraService cameraService;


    @Autowired
    public CameraController(@Qualifier("json") Serializer jsonSerializer, CameraService cameraService) {
        this.cameraService = cameraService;
        this.jsonSerializer = jsonSerializer;
    }

    public void importCameras() {
        CameraImportDto[] cameraImportDtos = this.jsonSerializer.deserialize(CameraImportDto[].class, CAMERAS_INPUT_JSON_PATH);
        this.cameraService.createMany(Arrays.asList(cameraImportDtos));
    }
}
