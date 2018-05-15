package vehicles.services;

import vehicles.entities.Passenger;
import vehicles.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public List<Passenger> findAll() {
        return this.passengerRepository.findAll();
    }

    @Override
    public Passenger findById(long id) {
        return this.passengerRepository.findOne(id);
    }

    @Override
    public Passenger create(Passenger passenger) {
        return this.passengerRepository.save(passenger);
    }

    @Override
    public List<Passenger> multipleCreate(Iterable<Passenger> passengers) {
        return this.passengerRepository.save(passengers);
    }

    @Override
    public void deleteById(long id) {
        this.passengerRepository.delete(id);
    }

}
