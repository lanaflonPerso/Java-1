package hospital.services;

import hospital.entities.Medicament;
import hospital.repositories.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MedicamentServiceImpl implements MedicamentService {

    private final MedicamentRepository medicamentRepository;

    @Autowired
    public MedicamentServiceImpl(MedicamentRepository medicamentRepository) {
        this.medicamentRepository = medicamentRepository;
    }

    @Override
    public List<Medicament> findAll() {
        return this.medicamentRepository.findAll();
    }

    @Override
    public Medicament findById(long id) {
        return this.medicamentRepository.findOne(id);
    }

    @Override
    public Medicament create(Medicament medicament) {
        return this.medicamentRepository.save(medicament);
    }

    @Override
    public List<Medicament> multipleCreate(Iterable<Medicament> medicaments) {
        return this.medicamentRepository.save(medicaments);
    }

    @Override
    public void deleteById(long id) {
        this.medicamentRepository.delete(id);
    }

}
