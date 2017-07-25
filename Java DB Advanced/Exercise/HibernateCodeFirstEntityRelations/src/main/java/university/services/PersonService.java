package university.services;

import university.entities.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();

    Person findById(long id);

    Person create(Person person);

    List<Person> multipleCreate(Iterable<Person> persons);

    void deleteById(long id);
}
