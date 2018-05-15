package hiberspring.repositories;

import hiberspring.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {

    Town getTownByName(String name);

    @Query(value = "SELECT t.town_name, t.population, sum(p.count_of_clients) AS count\n" +
            "FROM towns AS t\n" +
            "INNER JOIN branches AS b\n" +
            "ON t.town_id = b.town_id\n" +
            "LEFT JOIN products AS p\n" +
            "ON b.branch_id = p.branch_id\n" +
            "GROUP BY t.town_name, t.population\n" +
            "ORDER BY count DESC;", nativeQuery = true)
    List<Object> getTownWithClients();
}
