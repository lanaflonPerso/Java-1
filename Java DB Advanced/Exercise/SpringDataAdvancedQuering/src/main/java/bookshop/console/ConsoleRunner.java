package bookshop.console;

import bookshop.controllers.AuthorController;
import bookshop.controllers.BookController;
import bookshop.controllers.CategoryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //Seed Data into the Database
//        this.categoryController.seedData();
//        this.authorController.seedData();
//        this.bookController.seedData();

        //1.	Books Titles by Age Restriction
        //this.bookController.printBooksByAgeRestriction(bufferedReader.readLine());

        //2.	Golden Books
        //this.bookController.printGoldenBooks();

        //3.	Books by Price
        //this.bookController.printBooksByPrice();

        //4.	Not Released Books
        //this.bookController.printNotReleasedBooks(Integer.parseInt(bufferedReader.readLine()));

        //5.	Book Titles by Category
        //this.bookController.printBooksByCategories(Arrays.asList(bufferedReader.readLine().split("\\s+")));

        //6.	Books Released Before Date
        //this.bookController.printBooksReleasedDateBefore(bufferedReader.readLine());

        //7.	Authors Search
        //this.authorController.printAuthorsNameBySubstring(bufferedReader.readLine());

        //8.	Books Search
        //this.bookController.printBookNamesBySubstring(bufferedReader.readLine());

        //9.	Book Titles Search
        //this.bookController.printBooksNameByByAuthorLastNameStart(bufferedReader.readLine());

        //10.	Count Books
        //this.bookController.printCountOfBooksByTitleLengthGreaterThen(Integer.parseInt(bufferedReader.readLine()));

        //11.	Total Book Copies
        //this.bookController.printCopiesByAuthor();

        //12.	Find Profit
        //this.bookController.printProfitByCategory();

        //13.	Most Recent Books
        //this.categoryController.mostRecentBooksByCategory();

        //14.	Reduced Book
        //this.bookController.printReduceBooks(bufferedReader.readLine());

        //15.	* Increase Book Copies
        //this.bookController.printAddedCopies(bufferedReader.readLine(), Integer.parseInt(bufferedReader.readLine()));

        //16.	* Remove Books
        //this.bookController.printCountOfDeletedBooks(Integer.parseInt(bufferedReader.readLine()));

        //17.	* Stored ProcedureTable
        //this.bookController.printCountOfBooksByAuthor(bufferedReader.readLine());
    }
}