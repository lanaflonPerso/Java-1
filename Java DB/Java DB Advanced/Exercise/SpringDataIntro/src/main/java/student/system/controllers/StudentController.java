package student.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import student.system.entities.Student;
import student.system.services.StudentService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public void lisStudentsWithSubmissions() {
        List<Student> allStudents = this.studentService.findAll();
        allStudents.forEach(x -> {
            System.out.println(
                    String.format("Student name: %s. Submissions:%s%s",
                            x.getName(),
                            System.lineSeparator(),
                            x.getHomeworkSubmissions().stream()
                                    .map(y -> String.format("%s %s", y.getContent(), y.getContentType())).collect(Collectors.joining(System.lineSeparator()))));
        });
    }


    public void listStudentInfo() {
        List<String> students = this.studentService.findStudentsInfo();
        System.out.println(students);
    }
}