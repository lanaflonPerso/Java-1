package student.system.services;

import student.system.entities.License;
import student.system.repositories.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class LicenseServiceImpl implements LicenseService {

    private final LicenseRepository licenseRepository;

    @Autowired
    public LicenseServiceImpl(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    @Override
    public List<License> findAll() {
        return this.licenseRepository.findAll();
    }

    @Override
    public License findById(long id) {
        return this.licenseRepository.findOne(id);
    }

    @Override
    public License createOne(License license) {
        return this.licenseRepository.save(license);
    }

    @Override
    public List<License> createMany(Iterable<License> licenses) {
        return this.licenseRepository.save(licenses);
    }

    @Override
    public License updateOne(License license) {
        return this.licenseRepository.save(license);
    }

    @Override
    public List<License> updateMany(Iterable<License> licenses) {
        return this.licenseRepository.save(licenses);
    }

    @Override
    public void deleteById(long id) {
        this.licenseRepository.delete(id);
    }

}
