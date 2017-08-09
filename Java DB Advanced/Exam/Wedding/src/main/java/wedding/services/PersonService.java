package wedding.services;

import wedding.dtos.bindings.PeopleImportFromJsonDto;
import wedding.entities.Person;

import java.util.List;

public interface PersonService {

    Person createOne(PeopleImportFromJsonDto peopleImportFromJsonDto);

    List<Person> createMany(Iterable<Person> persons);

}
