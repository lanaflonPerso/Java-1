package sales.services;

import sales.entities.Sale;
import sales.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> findAll() {
        return this.saleRepository.findAll();
    }

    @Override
    public Sale findById(long id) {
        return this.saleRepository.findOne(id);
    }

    @Override
    public Sale create(Sale sale) {
        return this.saleRepository.save(sale);
    }

    @Override
    public List<Sale> multipleCreate(Iterable<Sale> sales) {
        return this.saleRepository.save(sales);
    }

    @Override
    public void deleteById(long id) {
        this.saleRepository.delete(id);
    }

}
