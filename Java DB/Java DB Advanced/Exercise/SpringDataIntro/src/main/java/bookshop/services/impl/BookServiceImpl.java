package bookshop.services.impl;

import bookshop.entities.Book;
import bookshop.repositories.api.BookRepository;
import bookshop.services.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hristo Skipernov on 21/07/2017.
 */

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
    public Book create(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> createAll(Iterable<Book> books) {
        return this.bookRepository.save(books);
    }

    @Override
    public void deleteById(long id) {
        this.bookRepository.delete(id);
    }

    @Override
    public List<String> findAllBooksAfter2000() {
        return this.bookRepository.findAllBooksAfter2000();
    }

    @Override
    public List<Book> findBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateAndTitle() {
        return this.bookRepository.findBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc("George", "Powell");
    }
}