package photography.services;

import photography.dtos.bindings.CameraImportFromJsonDto;
import photography.entities.Camera;

import java.util.List;

public interface CameraService {

    List<Camera> findAll();

    Camera findById(long id);

    Camera createOne(CameraImportFromJsonDto cameraImportFromJsonDto);

    List<Camera> createMany(Iterable<Camera> cameras);

    Camera updateOne(Camera camera);

    List<Camera> updateMany(Iterable<Camera> cameras);

    void deleteById(long id);

    void deleteByCamera(Camera camera);
}
