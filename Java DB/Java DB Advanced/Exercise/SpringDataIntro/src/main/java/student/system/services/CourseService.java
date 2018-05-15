package student.system.services;

import org.springframework.data.repository.query.Param;
import student.system.entities.Course;

import java.time.LocalDate;
import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course findById(long id);

    Course createOne(Course course);

    List<Course> createMany(Iterable<Course> courses);

    Course updateOne(Course course);

    List<Course> updateMany(Iterable<Course> courses);

    void deleteById(long id);

    List<Course> findCoursesOrderByStartDateEndDate();

    List<String> findCoursesWithMoreThan5Resources();

    List<String> coursesActiveOnDate(@Param("date") LocalDate date);
}
