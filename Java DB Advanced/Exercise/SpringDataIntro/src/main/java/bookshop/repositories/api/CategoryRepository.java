package bookshop.repositories.api;

import bookshop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hristo Skipernov on 21/07/2017.
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByNameIsStartingWith(String string);
}
