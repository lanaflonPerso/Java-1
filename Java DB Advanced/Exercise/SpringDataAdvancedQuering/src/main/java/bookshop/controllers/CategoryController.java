package bookshop.controllers;

import bookshop.entities.Category;
import bookshop.services.CategoryService;
import bookshop.utilities.ReadCategoryFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

/**
 * Created by Hristo Skipernov on 25/07/2017.
 */

@Controller
public class CategoryController {
    private static final String CATEGORIES_FILE_PATH = "H:\\SoftUni\\Java\\Java DB Fundamentals\\Databases Advanced - Hibernate\\SpringDataAdvancedQuering\\src\\main\\resources\\files\\categories.txt";

    private final CategoryService categoryService;
    private final ReadCategoryFile categoryFile;

    @Autowired
    public CategoryController(CategoryService categoryService, ReadCategoryFile categoryFile) {
        this.categoryService = categoryService;
        this.categoryFile = categoryFile;
    }


    public void seedData() throws IOException {
        this.categoryService.createMany(this.categoryFile.read(CATEGORIES_FILE_PATH));
    }

    public void mostRecentBooksByCategory() {
        List<Category> allCategories = this.categoryService.findAll();

        allCategories.stream()
                .sorted((c1, c2) -> c2.getBooks().size() - c1.getBooks().size())
                .forEach(c -> {

                    System.out.println(String.format("--%s: %d books", c.getName(), c.getBooks().size()));

                    c.getBooks().stream()
                            .sorted((b1, b2) -> {
                                int comp1 = b2.getReleaseDate().compareTo(b1.getReleaseDate());
                                if (comp1 != 0) {
                                    return comp1;
                                }
                                return b1.getTitle().compareTo(b2.getTitle());
                            })
                            .limit(3)
                            .forEach(b -> {

                                System.out.println(String.format("%s (%s)", b.getTitle(), b.getReleaseDate().getYear()));

                            });

                });
    }
}
