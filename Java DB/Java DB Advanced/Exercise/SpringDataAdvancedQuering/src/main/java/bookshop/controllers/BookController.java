package bookshop.controllers;

import bookshop.entities.Book;
import bookshop.entities.ReduceBook;
import bookshop.enums.AgeRestriction;
import bookshop.enums.EditionType;
import bookshop.services.BookService;
import bookshop.utilities.ReadBookFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Hristo Skipernov on 25/07/2017.
 */

@Controller
public class BookController {
    private static final String BOOKS_FILE_PATH = "H:\\SoftUni\\Java\\Java DB Fundamentals\\Databases Advanced - Hibernate\\SpringDataAdvancedQuering\\src\\main\\resources\\files\\books.txt";

    private final BookService bookService;
    private final ReadBookFile bookFile;

    @Autowired
    public BookController(BookService bookService, ReadBookFile bookFile) {
        this.bookService = bookService;
        this.bookFile = bookFile;
    }

    public void seedData() throws IOException {
        this.bookService.createMany(this.bookFile.read(BOOKS_FILE_PATH));
    }

    public void printBooksByAgeRestriction(String ageRestriction) {
        if (Arrays.stream(AgeRestriction.values()).filter(x -> x.toString().toLowerCase().equals(ageRestriction.toLowerCase())).count() == 0) {
            System.out.println("Age restriction type not exist");
        }

        int ageRestrictionValue = AgeRestriction.valueOf(ageRestriction.toUpperCase()).getValue();
        System.out.println(String.format("%s", String.join(System.lineSeparator(), this.bookService.getBooksByAgeRestriction(ageRestrictionValue))));
    }

    public void printGoldenBooks() {
        System.out.println(String.join(System.lineSeparator(), this.bookService.getGoldenBooks(EditionType.GOLD.getValue())));
    }

    public void printBooksByPrice() {
        System.out.println(String.join(System.lineSeparator(), this.bookService.getBooksByPrice()));
    }

    public void printNotReleasedBooks(int year) {
        System.out.println(String.join(System.lineSeparator(), this.bookService.getBooksNotReleasedByYear(year)));
    }

    public void printBooksReleasedDateBefore(String stringDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(stringDate, dtf);
        LocalDateTime localDateTime = LocalDateTime.of(date, LocalDateTime.now().toLocalTime());
        List<Book> books = this.bookService.getBooksByReleaseDateBefore(localDateTime);

        System.out.println(String.join(System.lineSeparator(), books.stream().map(x -> String.format("%s %s %s", x.getTitle(), Arrays.stream(EditionType.values()).filter(y -> y.getValue() == x.getEditionType()).findFirst().orElse(null).toString(), x.getPrice())).collect(Collectors.toList())));
    }

    public void printBooksByCategories(List<String> categories) {
        System.out.println(String.join(System.lineSeparator(), this.bookService.getBooksByCategories(categories)));
    }

    public void printBookNamesBySubstring(String substring) {
        System.out.println(String.join(System.lineSeparator(), this.bookService.getBookNamesBySubstring(substring)));
    }

    public void printBooksNameByByAuthorLastNameStart(String substring) {
        System.out.println(String.join(System.lineSeparator(), this.bookService.getBooksNameByByAuthorLastNameStart(substring, substring)));
    }

    public void printCountOfBooksByTitleLengthGreaterThen(int length) {
        System.out.println(this.bookService.countBooksByLengthOfTitle(length));
    }

    public void printCopiesByAuthor() {
        System.out.println(String.join(System.lineSeparator(), this.bookService.getTotalBookCopiesByAuthor()));
    }

    public void printProfitByCategory() {
        System.out.println(String.join(System.lineSeparator(), this.bookService.getProfitByCategory()));
    }

    public void printReduceBooks(String title) {
        List<ReduceBook> reduceBook = this.bookService.getReduceBook(title);
        reduceBook.stream()
                .map(rb -> String.format("%s %s %s %.2f",
                        rb.getTitle(),
                        Arrays.stream(EditionType.values()).filter(et -> et.getValue() == rb.getEditionType()).findFirst().orElse(null).toString(),
                        Arrays.stream(AgeRestriction.values()).filter(ar -> ar.getValue() == rb.getAgeRestriction()).findFirst().orElse(null).toString(),
                        rb.getPrice()))
                .forEach(System.out::println);
    }

    public void printAddedCopies(String stringDate, int copies) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate date = LocalDate.parse(stringDate, dtf);
        LocalDateTime localDateTime = LocalDateTime.of(date, LocalDateTime.now().toLocalTime());

        System.out.println(this.bookService.getAmountOfAddedCopies(localDateTime, copies) * copies);
    }

    public void printCountOfDeletedBooks(int copies) {

        List<Long> collect = this.bookService.findAll().stream()
                .filter(b -> b.getCopies() < copies)
                .map(Book::getId)
                .collect(Collectors.toList());

        this.bookService.getDeletedCategoriesBooksLines(collect);

        System.out.println(String.format("%d books were deleted", this.bookService.getDeletedBooks(copies)));
    }

    public void printCountOfBooksByAuthor(String name) {
        String[] splitName = name.split("\\s+");
        int countBooksByAuthor = this.bookService.getCountBooksByAuthor(splitName[0], splitName[1]);
        System.out.println(String.format("%s %s has %s", splitName[0], splitName[1], countBooksByAuthor == 0 ? "has not written any books yet" : "written " + countBooksByAuthor + " books"));
    }
}
