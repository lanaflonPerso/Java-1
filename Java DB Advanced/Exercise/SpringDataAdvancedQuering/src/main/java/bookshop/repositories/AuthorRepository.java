package bookshop.repositories;

import bookshop.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "SELECT concat_ws(' ', a.first_name, a.last_name) FROM book_shop_system.authors AS a WHERE right(a.first_name, length((?1))) = (?2);", nativeQuery = true)
    List<String> getAuthorsSearch(String substr1, String substr2);
}
