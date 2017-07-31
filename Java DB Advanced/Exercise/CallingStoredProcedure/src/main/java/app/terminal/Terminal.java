package app.terminal;

import app.controllers.BookController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Hristo Skipernov on 21/07/2017.
 */

@Component
public class Terminal implements CommandLineRunner {

    private final BookController bookController;

    @Autowired
    public Terminal(BookController bookController) {
        this.bookController = bookController;
    }

    @Override
    public void run(String... strings) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //17.	* Stored ProcedureTable
        this.bookController.printCountOfBooksByAuthor(bufferedReader.readLine());
    }
}