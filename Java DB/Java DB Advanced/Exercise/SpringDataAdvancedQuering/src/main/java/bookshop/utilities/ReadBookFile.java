package bookshop.utilities;

import bookshop.entities.Book;
import bookshop.entities.Category;
import bookshop.services.AuthorService;
import bookshop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Hristo Skipernov on 21/07/2017.
 */

@Component
public class ReadBookFile {

    private final CategoryService categoryService;
    private final AuthorService authorService;

    @Autowired
    public ReadBookFile(CategoryService categoryService, AuthorService authorService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    public List<Book> read(String filePath) throws IOException {
        List<Book> books = new ArrayList<>();
        Path bookPath = Paths.get(filePath);
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
        List<Category> allCategories = this.categoryService.findAll();
        Random random = new Random();

        for (String line : Files.readAllLines(bookPath).stream().skip(1).toArray(String[]::new)) {
            String[] tokens = line.split("\\s+");
            try {
                Constructor<Book> declaredConstructor = Book.class.getDeclaredConstructor();
                Book book = declaredConstructor.newInstance();
                book.setEditionType(Integer.parseInt(tokens[0]));
                LocalDate localDate = LocalDate.parse(tokens[1], dtf);
                LocalDateTime parse = LocalDateTime.of(localDate, LocalDateTime.now().toLocalTime());
                book.setReleaseDate(parse);
                book.setCopies(Integer.parseInt(tokens[2]));
                book.setPrice(BigDecimal.valueOf(Double.parseDouble(tokens[3])));
                book.setAgeRestriction(Integer.parseInt(tokens[4]));
                String title = Arrays.stream(tokens).skip(5).collect(Collectors.joining(" "));
                book.setTitle(title);

                Set<Category> categories = new HashSet<>();

                for (int i = 0; i < 3; i++) {
                    int index = random.nextInt(allCategories.size());
                    categories.add(allCategories.get(index));
                }

                book.setCategories(categories);
                book.setAuthor(this.authorService.findById(random.nextInt(30)));
                books.add(book);
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return books;
    }
}