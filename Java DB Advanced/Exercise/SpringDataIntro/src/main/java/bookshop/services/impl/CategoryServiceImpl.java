package bookshop.services.impl;

import bookshop.entities.Category;
import bookshop.repositories.api.CategoryRepository;
import bookshop.services.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hristo Skipernov on 21/07/2017.
 */

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findById(long id) {
        return this.categoryRepository.findOne(id);
    }

    @Override
    public Category create(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public List<Category> createAll(Iterable<Category> categories) {
        return this.categoryRepository.save(categories);
    }

    @Override
    public void deleteById(long id) {
        this.categoryRepository.delete(id);
    }
}