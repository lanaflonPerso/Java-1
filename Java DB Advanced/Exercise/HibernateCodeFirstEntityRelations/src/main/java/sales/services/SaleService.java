package sales.services;

import sales.entities.Sale;

import java.util.List;

public interface SaleService {

    List<Sale> findAll();

    Sale findById(long id);

    Sale create(Sale sale);

    List<Sale> multipleCreate(Iterable<Sale> sales);

    void deleteById(long id);
}
