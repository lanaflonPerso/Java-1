package hotel.services;

import hotel.entities.Payment;
import hotel.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> findAll() {
        return this.paymentRepository.findAll();
    }

    @Override
    public Payment findById(long id) {
        return this.paymentRepository.findOne(id);
    }

    @Override
    public Payment create(Payment payment) {
        return this.paymentRepository.save(payment);
    }

    @Override
    public List<Payment> multipleCreate(Iterable<Payment> payments) {
        return this.paymentRepository.save(payments);
    }

    @Override
    public void deleteById(long id) {
        this.paymentRepository.delete(id);
    }

}
