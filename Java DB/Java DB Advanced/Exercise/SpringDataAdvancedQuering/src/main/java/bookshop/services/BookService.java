package bookshop.services;

import bookshop.entities.Book;
import bookshop.entities.ReduceBook;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(long id);

    Book createOne(Book book);

    List<Book> createMany(Iterable<Book> books);

    Book updateOne(Book book);

    List<Book> updateMany(Iterable<Book> books);

    void deleteById(long id);

    List<String> getBooksByAgeRestriction(@Param("ageRestriction") int ageRestriction);

    List<String> getGoldenBooks(@Param("type") int editionType);

    List<String> getBooksByPrice();

    List<String> getBooksNotReleasedByYear(@Param("year") int year);

    List<String> getProfitByCategory();

    List<String> getBooksByCategories(@Param("categories") List<String> categories);

    List<Book> getBooksByReleaseDateBefore(LocalDateTime releaseDate);

    List<String> getBookNamesBySubstring(@Param("substring") String substring);

    List<String> getBooksNameByByAuthorLastNameStart(String substring1, String substring2);

    Long countBooksByLengthOfTitle(@Param("length") int length);

    List<String> getTotalBookCopiesByAuthor();

    List<ReduceBook> getReduceBook(@Param("title") String title);

    int getAmountOfAddedCopies(@Param("date") LocalDateTime localDateTime, @Param("copies") int copies);

    int getDeletedBooks(@Param("copies") int copies);

    int getDeletedCategoriesBooksLines(@Param("ids") List<Long> ids);

    int getCountBooksByAuthor(@Param("first_name") String firstName, @Param("last_name") String lastName);
}
