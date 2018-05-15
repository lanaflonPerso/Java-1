package bookshop.services.api;

import bookshop.entities.Category;

import java.util.List;

/**
 * Created by Hristo Skipernov on 21/07/2017.
 */

public interface CategoryService {

    List<Category> findAll();

    Category findById(long id);

    Category create(Category category);

    List<Category> createAll(Iterable<Category> categories);

    void deleteById(long id);

}
