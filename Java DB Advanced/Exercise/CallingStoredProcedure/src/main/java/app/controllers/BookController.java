package app.controllers;

import app.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Hristo Skipernov on 25/07/2017.
 */

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public void printCountOfBooksByAuthor(String name) {
        String[] splitName = name.split("\\s+");
        int countBooksByAuthor = this.bookService.getCountOfWrittenBooks(splitName[0], splitName[1]);
        System.out.println(String.format("%s %s has %s", splitName[0], splitName[1], countBooksByAuthor == 0 ? "has not written any books yet" : "written " + countBooksByAuthor + " books"));
    }
}
