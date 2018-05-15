package betting.repositories;

import betting.entities.CompetitionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionTypeRepository extends JpaRepository<CompetitionType, Long> {
}
