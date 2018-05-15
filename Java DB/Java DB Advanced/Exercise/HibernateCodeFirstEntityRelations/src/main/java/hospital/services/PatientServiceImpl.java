package hospital.services;

import hospital.entities.Patient;
import hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findAll() {
        return this.patientRepository.findAll();
    }

    @Override
    public Patient findById(long id) {
        return this.patientRepository.findOne(id);
    }

    @Override
    public Patient create(Patient patient) {
        return this.patientRepository.save(patient);
    }

    @Override
    public List<Patient> multipleCreate(Iterable<Patient> patients) {
        return this.patientRepository.save(patients);
    }

    @Override
    public void deleteById(long id) {
        this.patientRepository.delete(id);
    }

}
