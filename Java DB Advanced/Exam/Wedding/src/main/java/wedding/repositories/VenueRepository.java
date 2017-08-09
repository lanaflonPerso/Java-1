package wedding.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import wedding.entities.Venue;

import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {

    @Query(value = "SELECT v.*\n" +
            "  FROM venues AS v\n" +
            "    INNER JOIN weddings_venues AS wv\n" +
            "    ON v.venue_id = wv.venue_id\n" +
            "WHERE v.town = 'Sofia'\n" +
            "GROUP BY v.venue_id\n" +
            "HAVING count(wv.wedding_id) >= 3;", nativeQuery = true)
    List<Venue> getVenuesInSofia();
}
