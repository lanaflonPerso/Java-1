package photography.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import photography.constants.MessageConstants;
import photography.dtos.bindings.CameraImportFromJsonDto;
import photography.entities.Camera;
import photography.io.Writer;
import photography.serializers.Serializer;
import photography.services.CameraService;

@Controller
public class CameraController {
    private static final String SUCCESSFULLY_IMPORTED_CAMERA_MESSAGE = "Successfully imported %s %s %s";
    private static final String CAMERAS_JSON_INPUT_PATH = "/jsons/input/cameras.json";

    private final Serializer jsonSerializer;
    private final Serializer xmlSerializer;
    private final CameraService cameraService;
    private final Writer writer;

    @Autowired
    public CameraController(@Qualifier("json") Serializer jsonSerializer, @Qualifier("xml") Serializer xmlSerializer, CameraService cameraService, Writer writer) {
        this.jsonSerializer = jsonSerializer;
        this.xmlSerializer = xmlSerializer;
        this.cameraService = cameraService;
        this.writer = writer;
    }

    public void importCameras() {
        CameraImportFromJsonDto[] cameraImportFromJsonDtos = this.jsonSerializer.deserialize(CameraImportFromJsonDto[].class, CAMERAS_JSON_INPUT_PATH);
        for (CameraImportFromJsonDto cameraImportFromJsonDto : cameraImportFromJsonDtos) {
            Camera camera = this.cameraService.createOne(cameraImportFromJsonDto);
            if (camera != null) {
                this.writer.println(SUCCESSFULLY_IMPORTED_CAMERA_MESSAGE, camera.getClass().getSimpleName(), camera.getMake(), camera.getModel());
            } else {
                this.writer.println(MessageConstants.INVALID_INPUT_DATA_MESSAGE);
            }
        }
    }
}
