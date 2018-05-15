package university.services;

import university.entities.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course findById(long id);

    Course create(Course course);

    List<Course> multipleCreate(Iterable<Course> courses);

    void deleteById(long id);
}
