package student.system.services;

import student.system.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(long id);

    Student createOne(Student student);

    List<Student> createMany(Iterable<Student> students);

    Student updateOne(Student student);

    List<Student> updateMany(Iterable<Student> students);

    void deleteById(long id);

    List<String> findStudentsInfo();
}
