package university.services;

import university.entities.Person;
import university.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return this.personRepository.findAll();
    }

    @Override
    public Person findById(long id) {
        return this.personRepository.findOne(id);
    }

    @Override
    public Person create(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public List<Person> multipleCreate(Iterable<Person> persons) {
        return this.personRepository.save(persons);
    }

    @Override
    public void deleteById(long id) {
        this.personRepository.delete(id);
    }

}
