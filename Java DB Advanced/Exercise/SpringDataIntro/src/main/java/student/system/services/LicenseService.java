package student.system.services;

import student.system.entities.License;

import java.util.List;

public interface LicenseService {

    List<License> findAll();

    License findById(long id);

    License createOne(License license);

    List<License> createMany(Iterable<License> licenses);

    License updateOne(License license);

    List<License> updateMany(Iterable<License> licenses);

    void deleteById(long id);
}
