package student.system.services;

import student.system.entities.Resource;

import java.util.List;

public interface ResourceService {

    List<Resource> findAll();

    Resource findById(long id);

    Resource createOne(Resource resource);

    List<Resource> createMany(Iterable<Resource> resources);

    Resource updateOne(Resource resource);

    List<Resource> updateMany(Iterable<Resource> resources);

    void deleteById(long id);
}
