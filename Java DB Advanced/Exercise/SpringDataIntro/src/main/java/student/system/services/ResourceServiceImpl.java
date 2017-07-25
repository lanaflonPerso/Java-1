package student.system.services;

import student.system.entities.Resource;
import student.system.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;

    @Autowired
    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public List<Resource> findAll() {
        return this.resourceRepository.findAll();
    }

    @Override
    public Resource findById(long id) {
        return this.resourceRepository.findOne(id);
    }

    @Override
    public Resource createOne(Resource resource) {
        return this.resourceRepository.save(resource);
    }

    @Override
    public List<Resource> createMany(Iterable<Resource> resources) {
        return this.resourceRepository.save(resources);
    }

    @Override
    public Resource updateOne(Resource resource) {
        return this.resourceRepository.save(resource);
    }

    @Override
    public List<Resource> updateMany(Iterable<Resource> resources) {
        return this.resourceRepository.save(resources);
    }

    @Override
    public void deleteById(long id) {
        this.resourceRepository.delete(id);
    }

}
