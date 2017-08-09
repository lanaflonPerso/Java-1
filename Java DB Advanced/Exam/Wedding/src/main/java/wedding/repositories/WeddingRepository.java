package wedding.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wedding.entities.Wedding;

@Repository
public interface WeddingRepository extends JpaRepository<Wedding, Long> {
}
