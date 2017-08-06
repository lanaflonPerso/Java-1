package photographers.services;

import photographers.dtos.bindings.CameraImportDto;
import photographers.entities.Camera;

import java.util.List;

public interface CameraService {

    List<Camera> findAll();

    Camera findById(long id);

    Camera createOne(Camera camera);

    List<Camera> createMany(List<CameraImportDto> cameraImportDtos);

    Camera updateOne(Camera camera);

    List<Camera> updateMany(Iterable<Camera> cameras);

    void deleteById(long id);

    void deleteByCamera(Camera camera);
}
