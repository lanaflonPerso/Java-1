package bookshop.controllers;

import bookshop.services.api.BookService;
import bookshop.utilities.ReadBookFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * Created by Hristo Skipernov on 25/07/2017.
 */

@Controller
public class BookController {
    private static final String BOOKS_FILE_PATH = "H:\\SoftUni\\Java\\Java DB Fundamentals\\Databases Advanced - Hibernate\\SpringDataIntro\\src\\main\\resources\\files\\books.txt";

    private final BookService bookService;
    private final ReadBookFile bookFile;

    @Autowired
    public BookController(BookService bookService, ReadBookFile bookFile) {
        this.bookService = bookService;
        this.bookFile = bookFile;
    }


    public void seedData() throws IOException {
        this.bookService.createAll(this.bookFile.read(BOOKS_FILE_PATH));
    }

    public void printBooksAfter2000Year() {
        this.bookService.findAllBooksAfter2000().forEach(System.out::println);
    }

    public void printBooksFromGeorgePowell() {
        this.bookService.findBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateAndTitle().forEach(b -> System.out.println(String.format("%s %s %d", b.getTitle(), b.getReleaseDate(), b.getCopies())));
    }
}
