package hotel.services;

import hotel.entities.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(long id);

    Customer create(Customer customer);

    List<Customer> multipleCreate(Iterable<Customer> customers);

    void deleteById(long id);
}
