package university.services;

import university.entities.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAll();

    Teacher findById(long id);

    Teacher create(Teacher teacher);

    List<Teacher> multipleCreate(Iterable<Teacher> teachers);

    void deleteById(long id);
}
