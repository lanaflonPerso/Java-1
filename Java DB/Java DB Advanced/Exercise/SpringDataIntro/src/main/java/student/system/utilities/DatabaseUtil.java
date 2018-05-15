package student.system.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import student.system.entities.Course;
import student.system.entities.HomeworkSubmission;
import student.system.entities.Resource;
import student.system.entities.Student;
import student.system.services.CourseService;
import student.system.services.HomeworkSubmissionService;
import student.system.services.ResourceService;
import student.system.services.StudentService;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 22/07/2017.
 */

@Component
public class DatabaseUtil {
    private final CourseService courseService;
    private final HomeworkSubmissionService homeworkSubmissionService;
    private final ResourceService resourceService;
    private final StudentService studentService;

    @Autowired
    private DatabaseUtil(CourseService courseService, HomeworkSubmissionService homeworkSubmissionService, ResourceService resourceService, StudentService studentService){
        this.courseService = courseService;//
        this.homeworkSubmissionService = homeworkSubmissionService;//
        this.resourceService = resourceService;//
        this.studentService = studentService;
    }

    public void seed() {
        Student student1 = new Student();
        student1.setName("Ico");
        student1.setBirthday(LocalDate.of(1984, 9, 23));
        student1.setRegistrationDate(LocalDate.now());
        student1.setPhoneNumber("08897589652");
        Student student2 = new Student();
        student2.setName("Maya");
        student2.setBirthday(LocalDate.of(1943, 2, 15));
        student2.setRegistrationDate(LocalDate.now());
        student2.setPhoneNumber("08847856985");
        Student student3 = new Student();
        student3.setName("Niki");
        student3.setBirthday(LocalDate.of(1978, 6, 8));
        student3.setRegistrationDate(LocalDate.now());
        student3.setPhoneNumber("0887958623");

        Course course1 = new Course();
        course1.setName("Spring");
        course1.setDescription("Spring framework");
        course1.setStartDate(LocalDate.now());
        course1.setPrice(390);
        Set<Student> students1 = new HashSet<>();
        students1.add(student1);
        students1.add(student2);
        course1.setStudents(students1);
        course1.setEndDate(LocalDate.of(2017, 9, 10));
        Course course2 = new Course();
        course2.setName("Jpa");
        course2.setDescription("Intro");
        course2.setStartDate(LocalDate.now());
        course2.setPrice(180);
        Set<Student> students2 = new HashSet<>();
        students2.add(student1);
        students2.add(student3);
        course2.setStudents(students2);
        course2.setEndDate(LocalDate.of(2017, 11, 23));
        Course course3 = new Course();
        course3.setName("Hibernate");
        course3.setDescription("Advanced");
        course3.setStartDate(LocalDate.now());
        course3.setPrice(270);
        Set<Student> students3 = new HashSet<>();
        students3.add(student2);
        students3.add(student3);
        course3.setStudents(students3);
        course3.setEndDate(LocalDate.of(2017, 8, 29));


        HomeworkSubmission submission1 = new HomeworkSubmission();
        submission1.setContent("spring data intro");
        submission1.setContentType("application\\zip");
        submission1.setCourse(course3);
        submission1.setStudent(student1);
        submission1.setSubmissionDate(LocalDate.now());
        HomeworkSubmission submission2 = new HomeworkSubmission();
        submission2.setContent("hibernate project");
        submission2.setContentType("application\\pdf");
        submission2.setCourse(course1);
        submission2.setStudent(student2);
        submission2.setSubmissionDate(LocalDate.now());
        HomeworkSubmission submission3 = new HomeworkSubmission();
        submission3.setContent("spring first code");
        submission3.setContentType("application\\zip");
        submission3.setCourse(course2);
        submission3.setStudent(student2);
        submission3.setSubmissionDate(LocalDate.now());

        Resource resource1 = new Resource();
        resource1.setName("stream video");
        resource1.setTypeOfResource("video");
        resource1.setURL("H:\\SoftUni\\Java\\presentationName.ptt");
        resource1.setCourse(course1);
        Resource resource2 = new Resource();
        resource2.setName("presentationName");
        resource2.setTypeOfResource("presentation");
        resource2.setURL("H:\\SoftUni\\Java\\Java DB Fundamentals\\presentationName.ptt");
        resource2.setCourse(course1);
        Resource resource3 = new Resource();
        resource3.setName("document info");
        resource3.setTypeOfResource("document");
        resource3.setURL("H:\\SoftUni\\Java\\Databases\\Java DB Fundamentals\\presentationName.ptt");
        resource3.setCourse(course1);

        Set<Course> courses1 = new HashSet<>();
        courses1.add(course1);
        student1.setCourses(courses1);

        Set<Course> courses2 = new HashSet<>();
        courses2.add(course1);
        courses2.add(course2);
        courses2.add(course3);
        student2.setCourses(courses2);

        Set<Course> courses3 = new HashSet<>();
        courses3.add(course1);
        courses3.add(course3);
        student3.setCourses(courses3);

        this.courseService.createOne(course1);
        this.courseService.createOne(course2);
        this.courseService.createOne(course3);
        this.studentService.createOne(student1);
        this.studentService.createOne(student2);
        this.studentService.createOne(student3);
        this.homeworkSubmissionService.createOne(submission1);
        this.homeworkSubmissionService.createOne(submission2);
        this.homeworkSubmissionService.createOne(submission3);
        this.resourceService.createOne(resource1);
        this.resourceService.createOne(resource2);
        this.resourceService.createOne(resource3);
    }
}
