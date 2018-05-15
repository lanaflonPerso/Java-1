package bookshop.repositories;

import bookshop.entities.ReduceBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hristo Skipernov on 26/07/2017.
 */

@Repository
public interface ReduceBookRepository extends JpaRepository<ReduceBook, Long> {

    @Query(value = "SELECT b.book_id, b.title, b.edition_type, b.age_restriction, b.price FROM book_shop_system.books AS b WHERE b.title = :title", nativeQuery = true)
    List<ReduceBook> getReduceBook(@Param("title") String title);
}
