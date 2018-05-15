package university.services;

import university.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(long id);

    Student create(Student student);

    List<Student> multipleCreate(Iterable<Student> students);

    void deleteById(long id);
}
