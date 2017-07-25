package bookshop.repositories.api;

import bookshop.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hristo Skipernov on 21/07/2017.
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select b.title from book_shop_system.books b where year(b.release_date) > '2000'", nativeQuery = true)
    List<String> findAllBooksAfter2000();

    List<Book> findBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String authorFirstName, String authorLastName);
}
