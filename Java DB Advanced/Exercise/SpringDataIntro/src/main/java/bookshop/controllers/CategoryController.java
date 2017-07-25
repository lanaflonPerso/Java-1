package bookshop.controllers;

import bookshop.services.api.CategoryService;
import bookshop.utilities.ReadCategoryFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * Created by Hristo Skipernov on 25/07/2017.
 */

@Controller
public class CategoryController {
    private static final String CATEGORIES_FILE_PATH = "H:\\SoftUni\\Java\\Java DB Fundamentals\\Databases Advanced - Hibernate\\SpringDataIntro\\src\\main\\resources\\files\\categories.txt";

    private final CategoryService categoryService;
    private final ReadCategoryFile categoryFile;

    @Autowired
    public CategoryController(CategoryService categoryService, ReadCategoryFile categoryFile) {
        this.categoryService = categoryService;
        this.categoryFile = categoryFile;
    }


    public void seedData() throws IOException {
        this.categoryService.createAll(this.categoryFile.read(CATEGORIES_FILE_PATH));
    }
}
