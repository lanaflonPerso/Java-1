package bookshop.console;

import bookshop.controllers.AuthorController;
import bookshop.controllers.BookController;
import bookshop.controllers.CategoryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Hristo Skipernov on 21/07/2017.
 */

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final BookController bookController;
    private final AuthorController authorController;
    private final CategoryController categoryController;

    @Autowired
    public ConsoleRunner(BookController bookController, AuthorController authorController, CategoryController categoryController) {
        this.bookController = bookController;
        this.authorController = authorController;
        this.categoryController = categoryController;
    }

    @Override
    public void run(String... strings) throws Exception {
        //Problem 2. Seed Data into the Database
        //this.categoryController.seedData();
        //this.authorController.seedData();
        //this.bookController.seedData();

        //Problem 3. Write Queries
        //this.bookController.printBooksAfter2000Year();
        //this.authorController.printAuthorsWithAtLeastOneBookBefore1990();
        //this.authorController.printAuthorsOrderByBooksCount();
        //this.bookController.printBooksFromGeorgePowell();
    }
}