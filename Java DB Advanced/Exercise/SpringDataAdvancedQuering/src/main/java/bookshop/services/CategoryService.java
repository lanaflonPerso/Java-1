package bookshop.services;

import bookshop.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(long id);

    Category createOne(Category category);

    List<Category> createMany(Iterable<Category> categorys);

    Category updateOne(Category category);

    List<Category> updateMany(Iterable<Category> categorys);

    void deleteById(long id);
}
