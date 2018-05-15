package university.services;

import university.entities.Course;
import university.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Course create(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    public List<Course> multipleCreate(Iterable<Course> courses) {
        return this.courseRepository.save(courses);
    }

    @Override
    public void deleteById(long id) {
        this.courseRepository.delete(id);
    }

}
