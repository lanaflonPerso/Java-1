package bookshop.services;

import bookshop.entities.Book;
import bookshop.entities.ReduceBook;
import bookshop.repositories.BookRepository;
import bookshop.repositories.ProcedureRepository;
import bookshop.repositories.ReduceBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ReduceBookRepository reduceBookRepository;
    private final ProcedureRepository procedureRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, ReduceBookRepository reduceBookRepository, ProcedureRepository procedureRepository) {
        this.bookRepository = bookRepository;
        this.reduceBookRepository = reduceBookRepository;
        this.procedureRepository = procedureRepository;
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
    public List<String> getBooksByAgeRestriction(@Param("ageRestriction") int ageRestriction) {
        return this.bookRepository.getBooksByAgeRestriction(ageRestriction);
    }

    @Override
    public List<String> getGoldenBooks(@Param("type") int editionType) {
        return this.bookRepository.getGoldenBooks(editionType);
    }

    @Override
    public List<String> getBooksByPrice() {
        return this.bookRepository.getBooksByPrice();
    }

    @Override
    public List<String> getBooksNotReleasedByYear(@Param("year") int year) {
        return this.bookRepository.getBooksNotReleasedByYear(year);
    }

    @Override
    public List<String> getBooksByCategories(@Param("categories") List<String> categories) {
        return this.bookRepository.getBooksByCategories(categories);
    }

    @Override
    public List<Book> getBooksByReleaseDateBefore(LocalDateTime releaseDate) {
        return this.bookRepository.getBooksByReleaseDateBefore(releaseDate);
    }

    @Override
    public List<String> getBookNamesBySubstring(@Param("substring") String substring) {
        return this.bookRepository.getBookNamesBySubstring(substring);
    }

    @Override
    public List<String> getBooksNameByByAuthorLastNameStart(String substring1, String substring2) {
        return this.bookRepository.getBooksNameByByAuthorLastNameStart(substring1, substring2);
    }

    @Override
    public Long countBooksByLengthOfTitle(@Param("length") int length) {
        return this.bookRepository.countBooksByLengthOfTitle(length);
    }

    @Override
    public List<String> getTotalBookCopiesByAuthor() {
        return this.bookRepository.getTotalBookCopiesByAuthor();
    }

    @Override
    public List<String> getProfitByCategory() {
        return this.bookRepository.getProfitByCategory();
    }

    public List<ReduceBook> getReduceBook(@Param("title") String title) {
        return this.reduceBookRepository.getReduceBook(title);
    }

    public int getAmountOfAddedCopies(@Param("date") LocalDateTime localDateTime, @Param("copies") int copies) {
        return this.bookRepository.getAmountOfAddedCopies(localDateTime, copies);
    }

    public int getDeletedBooks(@Param("copies") int copies) {
        return this.bookRepository.getDeletedBooks(copies);
    }

    public int getDeletedCategoriesBooksLines(@Param("ids") List<Long> ids) {
        return this.bookRepository.getDeletedCategoriesBooksLines(ids);
    }

    public int getCountBooksByAuthor(@Param("first_name") String firstName, @Param("last_name") String lastName) {
        return this.procedureRepository.getCountBooksByAuthor(firstName, lastName);
    }
}
