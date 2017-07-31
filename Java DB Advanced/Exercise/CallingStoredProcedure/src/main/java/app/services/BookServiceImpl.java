package app.services;

import app.entities.Book;
import app.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findById(long id) {
        return this.bookRepository.findOne(id);
    }

    @Override
    public Book createOne(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> createMany(Iterable<Book> books) {
        return this.bookRepository.save(books);
    }

    @Override
    public Book updateOne(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> updateMany(Iterable<Book> books) {
        return this.bookRepository.save(books);
    }

    @Override
    public void deleteById(long id) {
        this.bookRepository.delete(id);
    }

    @Override
    public int getCountOfWrittenBooks(String firstName, String lastName) {
        return this.bookRepository.getCountOfWrittenBooks(firstName, lastName);
    }

}
