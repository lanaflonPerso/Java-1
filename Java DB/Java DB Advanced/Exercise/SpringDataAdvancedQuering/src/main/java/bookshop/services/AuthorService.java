package bookshop.services;

import bookshop.entities.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    Author findById(long id);

    Author createOne(Author author);

    List<Author> createMany(Iterable<Author> authors);

    Author updateOne(Author author);

    List<Author> updateMany(Iterable<Author> authors);

    void deleteById(long id);

    List<String> getAuthorsSearch(String substr1, String substr2);
}
