package hotel.services;

import hotel.entities.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> findAll();

    Payment findById(long id);

    Payment create(Payment payment);

    List<Payment> multipleCreate(Iterable<Payment> payments);

    void deleteById(long id);
}
