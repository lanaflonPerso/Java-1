package bookshop.services.api;

import bookshop.entities.Author;

import java.util.List;

/**
 * Created by Hristo Skipernov on 21/07/2017.
 */

public interface AuthorService {

    List<Author> findAll();

    Author findById(long id);

    Author create(Author author);

    List<Author> createAll(Iterable<Author> authors);

    void deleteById(long id);

    List<Author> findAllByOrderByBooksDesc();

    List<Author> findAuthorsByBooksReleaseDateBefore1990();
}
