package student.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import student.system.entities.Course;
import student.system.services.CourseService;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

@Controller
public class CourseController {

    private final CourseService courseService;
    private final EntityManager em;


    @Autowired
    public CourseController(CourseService courseService, EntityManager em) {
        this.courseService = courseService;
        this.em = em;
    }

    public void listCoursesWithResources() {
        List<Course> allCourses = this.courseService.findCoursesOrderByStartDateEndDate();
        allCourses.forEach(c -> {
            System.out.println(
                    String.format("Course name: %s, description: %s. Resources:%s%s",
                            c.getName(),
                            c.getDescription(),
                            System.lineSeparator(),
                            c.getResources()));
        });
    }

    public void listCoursesWithMoreThan5Resources() {
        List<String> allCourses = this.courseService.findCoursesWithMoreThan5Resources();
        System.out.println(allCourses);
  }

    public void listCoursesByDateWithStudents(LocalDate date) {
        List<String> coursesByDateWithStudents = this.courseService.coursesActiveOnDate(date);
        System.out.println(coursesByDateWithStudents);
    }
}