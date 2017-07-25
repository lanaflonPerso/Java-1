package hospital.services;

import hospital.entities.Diagnose;
import hospital.repositories.DiagnoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DiagnoseServiceImpl implements DiagnoseService {

    private final DiagnoseRepository diagnoseRepository;

    @Autowired
    public DiagnoseServiceImpl(DiagnoseRepository diagnoseRepository) {
        this.diagnoseRepository = diagnoseRepository;
    }

    @Override
    public List<Diagnose> findAll() {
        return this.diagnoseRepository.findAll();
    }

    @Override
    public Diagnose findById(long id) {
        return this.diagnoseRepository.findOne(id);
    }

    @Override
    public Diagnose create(Diagnose diagnose) {
        return this.diagnoseRepository.save(diagnose);
    }

    @Override
    public List<Diagnose> multipleCreate(Iterable<Diagnose> diagnoses) {
        return this.diagnoseRepository.save(diagnoses);
    }

    @Override
    public void deleteById(long id) {
        this.diagnoseRepository.delete(id);
    }

}
