package bookshop.repositories;

import bookshop.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b.title from Book b where b.ageRestriction = :ageRestriction")
    List<String> getBooksByAgeRestriction(@Param("ageRestriction") int ageRestriction);

    @Query("select b.title from Book b where b.editionType = :type and b.copies < 5000")
    List<String> getGoldenBooks(@Param("type") int editionType);

    @Query("select concat(b.title, ' - $', b.price) from Book b where b.price < 5 or b.price > 40")
    List<String> getBooksByPrice();

    @Query(value = "SELECT b.title FROM book_shop_system.books AS b WHERE year(b.release_date) < :year", nativeQuery = true)
    List<String> getBooksNotReleasedByYear(@Param("year") int year);

    @Query(value = "SELECT b.title FROM book_shop_system.books AS b " +
            "INNER JOIN book_shop_system.books_categories AS bc " +
            "ON b.book_id = bc.book_id " +
            "INNER JOIN book_shop_system.categories AS c " +
            "ON bc.category_id = c.category_id " +
            "WHERE c.name IN :categories", nativeQuery = true)
    List<String> getBooksByCategories(@Param("categories") List<String> categories);

    List<Book> getBooksByReleaseDateBefore(LocalDateTime releaseDate);

    @Query(value = "SELECT b.title FROM book_shop_system.books AS b WHERE instr(b.title, :substring) > 0", nativeQuery = true)
    List<String> getBookNamesBySubstring(@Param("substring") String substring);

    @Query(value = "SELECT b.title FROM book_shop_system.books AS b " +
            "INNER JOIN book_shop_system.authors AS a " +
            "ON b.author_id = a.author_id " +
            "WHERE left(a.last_name, length((?1))) = (?2)", nativeQuery = true)
    List<String> getBooksNameByByAuthorLastNameStart(String substring1, String substring2);

    @Query("select count(b.id) from Book b where length(b.title) > :length")
    Long countBooksByLengthOfTitle(@Param("length") int length);

    @Query(value = "SELECT concat(a.first_name, ' ', a.last_name, ' - ', sum(b.copies)) FROM book_shop_system.books AS b " +
            "INNER JOIN book_shop_system.authors AS a " +
            "ON b.author_id = a.author_id " +
            "GROUP BY a.author_id " +
            "ORDER BY sum(b.copies) DESC", nativeQuery = true)
    List<String> getTotalBookCopiesByAuthor();

    @Query(value = "SELECT CONCAT_WS(' - $', c.name, sum(books_with_profit.profit))\n" +
            "  FROM (SELECT b.book_id, b.title, (b.price * b.copies) AS profit\n" +
            "        FROM books AS b) AS books_with_profit\n" +
            "INNER JOIN books_categories AS bc\n" +
            "ON books_with_profit.book_id = bc.book_id\n" +
            "INNER JOIN categories AS c\n" +
            "ON bc.category_id = c.category_id\n" +
            "GROUP BY c.name\n" +
            "ORDER BY sum(books_with_profit.profit) DESC, c.name;", nativeQuery = true)
    List<String> getProfitByCategory();

    @Modifying
    @Transactional
    @Query(value = "UPDATE book_shop_system.books AS b SET b.copies = b.copies + :copies WHERE b.release_date > :date", nativeQuery = true)
    int getAmountOfAddedCopies(@Param("date") LocalDateTime localDateTime, @Param("copies") int copies);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM book_shop_system.books WHERE books.copies < :copies", nativeQuery = true)
    int getDeletedBooks(@Param("copies") int copies);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM book_shop_system.books_categories WHERE books_categories.book_id IN :ids", nativeQuery = true)
    int getDeletedCategoriesBooksLines(@Param("ids") List<Long> ids);

}
