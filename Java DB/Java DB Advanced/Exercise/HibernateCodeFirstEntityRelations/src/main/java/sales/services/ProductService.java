package sales.services;

import sales.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(long id);

    Product create(Product product);

    List<Product> multipleCreate(Iterable<Product> products);

    void deleteById(long id);
}
