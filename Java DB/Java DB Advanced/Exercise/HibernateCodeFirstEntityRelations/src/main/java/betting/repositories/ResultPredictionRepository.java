package betting.repositories;

import betting.entities.ResultPrediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultPredictionRepository extends JpaRepository<ResultPrediction, Long> {
}
