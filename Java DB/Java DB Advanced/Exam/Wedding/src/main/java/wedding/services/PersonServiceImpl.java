package wedding.services;

import wedding.dtos.bindings.PeopleImportFromJsonDto;
import wedding.entities.Person;
import wedding.repositories.PersonRepository;
import wedding.utilities.MapperConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wedding.validators.DTOValidator;

import java.util.List;

@Transactional
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final MapperConverter mapperConverter;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, MapperConverter mapperConverter) {
        this.personRepository = personRepository;
        this.mapperConverter = mapperConverter;
    }

    @Override
    public Person createOne(PeopleImportFromJsonDto peopleImportFromJsonDto) {
        Person person = this.mapperConverter.convert(peopleImportFromJsonDto, Person.class);
        if (DTOValidator.isValid(person)) {
            return this.personRepository.save(person);
        }
        return null;
    }

    @Override
    public List<Person> createMany(Iterable<Person> persons) {
        return this.personRepository.save(persons);
    }

}
