package student.system.services;

import org.springframework.data.repository.query.Param;
import student.system.entities.Course;
import student.system.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public Course findById(long id) {
        return this.courseRepository.findOne(id);
    }

    @Override
    public Course createOne(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    public List<Course> createMany(Iterable<Course> courses) {
        return this.courseRepository.save(courses);
    }

    @Override
    public Course updateOne(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    public List<Course> updateMany(Iterable<Course> courses) {
        return this.courseRepository.save(courses);
    }

    @Override
    public void deleteById(long id) {
        this.courseRepository.delete(id);
    }

    @Override
    public List<Course> findCoursesOrderByStartDateEndDate() {
        return this.courseRepository.findCoursesByOrderByStartDateAscEndDateDesc();
    }

    @Override
    public List<String> findCoursesWithMoreThan5Resources() {
        return this.courseRepository.findCoursesWithMoreThan5Resources();
    }

    public List<String> coursesActiveOnDate(@Param("date") LocalDate date) {
        return this.courseRepository.coursesActiveOnDate(date);
    }
}
