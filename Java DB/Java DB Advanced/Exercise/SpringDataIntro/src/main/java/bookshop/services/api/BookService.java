package bookshop.services.api;

import bookshop.entities.Book;

import java.util.List;

/**
 * Created by Hristo Skipernov on 21/07/2017.
 */

public interface BookService {

    List<Book> findAll();

    Book findById(long id);

    Book create(Book book);

    List<Book> createAll(Iterable<Book> books);

    void deleteById(long id);

    List<String> findAllBooksAfter2000();

    List<Book> findBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateAndTitle();
}
