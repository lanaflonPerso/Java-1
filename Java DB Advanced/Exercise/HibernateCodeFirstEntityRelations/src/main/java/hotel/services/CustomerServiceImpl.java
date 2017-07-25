package hotel.services;

import hotel.entities.Customer;
import hotel.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer findById(long id) {
        return this.customerRepository.findOne(id);
    }

    @Override
    public Customer create(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public List<Customer> multipleCreate(Iterable<Customer> customers) {
        return this.customerRepository.save(customers);
    }

    @Override
    public void deleteById(long id) {
        this.customerRepository.delete(id);
    }

}
