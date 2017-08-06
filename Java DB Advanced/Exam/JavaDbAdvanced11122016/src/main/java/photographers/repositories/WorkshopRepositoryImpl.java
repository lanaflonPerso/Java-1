package photographers.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import photographers.entities.Photographer;
import photographers.entities.Workshop;

import javax.persistence.EntityManager;

@Repository
public class WorkshopRepositoryImpl implements WorkshopRepositoryCustom {

    private final EntityManager em;

    @Autowired
    public WorkshopRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Workshop createOne(Workshop workshop) {
        this.em.merge(workshop.getTrainer());
        if (workshop.getParticipants() != null) {
            for (Photographer photographer : workshop.getParticipants()) {
                this.em.merge(photographer);
            }
        }
        return this.em.merge(workshop);
    }
}
