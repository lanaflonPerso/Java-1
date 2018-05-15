package bookshop.controllers;

import bookshop.services.AuthorService;
import bookshop.utilities.ReadAuthorFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * Created by Hristo Skipernov on 25/07/2017.
 */

@Controller
public class AuthorController {
    private static final String AUTHORS_FILE_PATH = "H:\\SoftUni\\Java\\Java DB Fundamentals\\Databases Advanced - Hibernate\\SpringDataAdvancedQuering\\src\\main\\resources\\files\\authors.txt";

    private final AuthorService authorService;
    private final ReadAuthorFile authorFile;

    @Autowired
    public AuthorController(AuthorService authorService, ReadAuthorFile authorFile) {
        this.authorService = authorService;
        this.authorFile = authorFile;
    }

    public void seedData() throws IOException {
        this.authorService.createMany(this.authorFile.read(AUTHORS_FILE_PATH));
    }

    public void printAuthorsNameBySubstring(String substr) {
        System.out.println(String.join(System.lineSeparator(), this.authorService.getAuthorsSearch(substr, substr)));
    }

}
