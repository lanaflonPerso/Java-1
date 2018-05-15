package products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import products.dto.views.CategoryByProductsCountViewDto;
import products.dto.bindings.CategoryImportDto;
import products.serializers.JsonSerializer;
import products.serializers.Serializer;
import products.services.CategoryService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hristo Skipernov on 01/08/2017.
 */

@Controller
public class CategoryController {
    private static final String CATEGORIES_JASON_PATH = "/json/input/categories.json";
    private static final String PRODUCTS_CATEGORIES_BY_PRODUCTS_COUNT_JASON_OUTPUT_PATH = "src/main/resources/json/output/categories-by-products.json";

    private final CategoryService categoryService;
    private final Serializer jsonSerializer;

    @Autowired
    public CategoryController(CategoryService categoryService, JsonSerializer jsonSerializer) {
        this.categoryService = categoryService;
        this.jsonSerializer = jsonSerializer;
    }

    public void importCategories() throws IOException, InstantiationException, IllegalAccessException {
        CategoryImportDto[] categoryImportDtos = this.jsonSerializer.deserialize(CategoryImportDto[].class, CATEGORIES_JASON_PATH);
        this.categoryService.createMany(Arrays.asList(categoryImportDtos));
    }

    public void exportCategoriesByProductsCount() throws IOException {
        List<CategoryByProductsCountViewDto> categories = this.categoryService.getCategoriesByProductsCount();
        this.jsonSerializer.serialize(categories, PRODUCTS_CATEGORIES_BY_PRODUCTS_COUNT_JASON_OUTPUT_PATH);
    }
}
