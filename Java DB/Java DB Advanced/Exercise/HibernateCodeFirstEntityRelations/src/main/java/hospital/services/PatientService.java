package hospital.services;

import hospital.entities.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> findAll();

    Patient findById(long id);

    Patient create(Patient patient);

    List<Patient> multipleCreate(Iterable<Patient> patients);

    void deleteById(long id);
}
