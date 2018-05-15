package hospital.services;

import hospital.entities.Visitation;
import hospital.repositories.VisitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class VisitationServiceImpl implements VisitationService {

    private final VisitationRepository visitationRepository;

    @Autowired
    public VisitationServiceImpl(VisitationRepository visitationRepository) {
        this.visitationRepository = visitationRepository;
    }

    @Override
    public List<Visitation> findAll() {
        return this.visitationRepository.findAll();
    }

    @Override
    public Visitation findById(long id) {
        return this.visitationRepository.findOne(id);
    }

    @Override
    public Visitation create(Visitation visitation) {
        return this.visitationRepository.save(visitation);
    }

    @Override
    public List<Visitation> multipleCreate(Iterable<Visitation> visitations) {
        return this.visitationRepository.save(visitations);
    }

    @Override
    public void deleteById(long id) {
        this.visitationRepository.delete(id);
    }

}
