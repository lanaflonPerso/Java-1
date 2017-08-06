package photographers.utilities;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import photographers.dtos.bindings.PhotographerImportDto;
import photographers.dtos.utility.CameraIdAndMakeDto;
import photographers.dtos.utility.DslrUtilityDto;
import photographers.dtos.utility.MirrorlessUtilityDto;
import photographers.entities.Camera;
import photographers.entities.DSLR;
import photographers.entities.Mirrorless;
import photographers.entities.Photographer;
import photographers.io.Writer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hristo Skipernov on 27/07/2017.
 */

@Component
public class MapperConverter {

    private ModelMapper modelMapper;
    private final Writer writer;

    @Autowired
    public MapperConverter(Writer writer) {
        this.writer = writer;
        this.modelMapper = new ModelMapper();
    }

    public <S, D> D convert(S source, Class<D> destinationClass) {
        return this.modelMapper.map(source, destinationClass);
    }

    public <S, D> void convert(S source, D destination) {
        this.modelMapper.map(source, destination);
    }

    public List<CameraIdAndMakeDto> convertCamerasToCamerasDto(List<Camera> cameras, Class<CameraIdAndMakeDto> cameraIdAndMakeDtoClass) {
        this.modelMapper = new ModelMapper();

        TypeMap<Camera, CameraIdAndMakeDto> typeMap = this.modelMapper
                .createTypeMap(Camera.class, CameraIdAndMakeDto.class)
                .include(Camera.class, DslrUtilityDto.class)
                .include(Camera.class, MirrorlessUtilityDto.class);

        typeMap.setProvider(new Provider<CameraIdAndMakeDto>() {
            @Override
            public CameraIdAndMakeDto get(ProvisionRequest<CameraIdAndMakeDto> request) {
                Camera camera = (Camera) request.getSource();
                CameraIdAndMakeDto cameraIdAndMakeDto = null;
                if (camera.getClass().getSimpleName().contains("DSLR")) {
                    cameraIdAndMakeDto = modelMapper.map(camera, DslrUtilityDto.class);
                } else {
                    cameraIdAndMakeDto = modelMapper.map(camera, MirrorlessUtilityDto.class);
                    ;
                }
                return cameraIdAndMakeDto;
            }
        });

        List<CameraIdAndMakeDto> cameraIdAndMakeDtos = new ArrayList<>();
        for (Camera camera : cameras) {
            cameraIdAndMakeDtos.add(typeMap.map(camera));
        }
        return cameraIdAndMakeDtos;
    }

    public List<Photographer> convertPhotographersWithAbstractCameras(List<PhotographerImportDto> photographerImportDtos, Class<Photographer[]> photographerArrayClass) {
        TypeMap<PhotographerImportDto, Photographer> typeMap =
                modelMapper.createTypeMap(PhotographerImportDto.class, Photographer.class);

        Converter<CameraIdAndMakeDto, Camera> converter = new Converter<CameraIdAndMakeDto, Camera>() {
            @Override
            public Camera convert(MappingContext<CameraIdAndMakeDto, Camera> mappingContext) {
                CameraIdAndMakeDto source = mappingContext.getSource();

                Camera camera = null;
                if (source.getClass().getSimpleName().toLowerCase().contains("dslr")) {
                    camera = modelMapper.map(source, DSLR.class);

                } else if (source.getClass().getSimpleName().toLowerCase().contains("mirrorless")) {
                    camera = modelMapper.map(source, Mirrorless.class);
                }
                return camera;
            }
        };

        typeMap.addMappings(m -> m.using(converter).map(PhotographerImportDto::getPrimaryCamera, Photographer::setPrimaryCamera));
        typeMap.addMappings(m -> m.using(converter).map(PhotographerImportDto::getSecondaryCamera, Photographer::setSecondaryCamera));

        List<Photographer> photographers = new ArrayList<>();
        for (PhotographerImportDto photographerImportDto : photographerImportDtos) {
            photographers.add(typeMap.map(photographerImportDto));
        }

        return photographers;
    }
}