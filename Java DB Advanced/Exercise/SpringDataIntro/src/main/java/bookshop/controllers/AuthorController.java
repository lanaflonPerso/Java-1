package bookshop.controllers;

import bookshop.services.api.AuthorService;
import bookshop.utilities.ReadAuthorFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * Created by Hristo Skipernov on 25/07/2017.
 */

@Controller
public class AuthorController {
    private static final String AUTHORS_FILE_PATH = "H:\\SoftUni\\Java\\Java DB Fundamentals\\Databases Advanced - Hibernate\\SpringDataIntro\\src\\main\\resources\\files\\authors.txt";

    private final AuthorService authorService;
    private final ReadAuthorFile authorFile;

    @Autowired
    public AuthorController(AuthorService authorService, ReadAuthorFile authorFile) {
        this.authorService = authorService;
        this.authorFile = authorFile;
    }

    public void seedData() throws IOException {
        this.authorService.createAll(this.authorFile.read(AUTHORS_FILE_PATH));
    }

    public void printAuthorsWithAtLeastOneBookBefore1990() {
        this.authorService.findAllByOrderByBooksDesc().forEach(a -> System.out.println(String.format("%s %s %d", a.getFirstName(), a.getLastName(), a.getBooks().size())));
    }

    public void printAuthorsOrderByBooksCount() {
        this.authorService.findAuthorsByBooksReleaseDateBefore1990().forEach(a -> System.out.println(String.format("%s %s", a.getFirstName(), a.getLastName())));
    }
}
