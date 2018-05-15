package hospital.services;

import hospital.entities.Visitation;

import java.util.List;

public interface VisitationService {

    List<Visitation> findAll();

    Visitation findById(long id);

    Visitation create(Visitation visitation);

    List<Visitation> multipleCreate(Iterable<Visitation> visitations);

    void deleteById(long id);
}
