package app.services;

import app.entities.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(long id);

    Book createOne(Book book);

    List<Book> createMany(Iterable<Book> books);

    Book updateOne(Book book);

    List<Book> updateMany(Iterable<Book> books);

    void deleteById(long id);

    int getCountOfWrittenBooks(String firstName, String lastName);

}
