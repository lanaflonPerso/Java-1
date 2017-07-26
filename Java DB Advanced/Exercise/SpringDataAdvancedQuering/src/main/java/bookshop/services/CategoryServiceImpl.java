package bookshop.services;

import bookshop.entities.Category;
import bookshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Category createOne(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public List<Category> createMany(Iterable<Category> categorys) {
        return this.categoryRepository.save(categorys);
    }

    @Override
    public Category updateOne(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public List<Category> updateMany(Iterable<Category> categorys) {
        return this.categoryRepository.save(categorys);
    }

    @Override
    public void deleteById(long id) {
        this.categoryRepository.delete(id);
    }

}
