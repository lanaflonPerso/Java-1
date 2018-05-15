package student.system.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import student.system.controllers.CourseController;
import student.system.controllers.StudentController;
import student.system.controllers.UserController;
import student.system.utilities.DatabaseUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Hristo Skipernov on 21/07/2017.
 */

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final CourseController courseController;
    private final StudentController studentController;
    private final UserController userController;
    private final DatabaseUtil databaseUtil;

    @Autowired
    public ConsoleRunner(CourseController courseController, StudentController studentController, UserController userController, DatabaseUtil databaseUtil) {
        this.courseController = courseController;
        this.studentController = studentController;
        this.userController = userController;
        this.databaseUtil = databaseUtil;
    }

    @Override
    public void run(String... strings) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //Problem 6. Seed Some Data in the Database
        //this.databaseUtil.seed();

        //Problem 7. Working with the Database
        //this.studentController.lisStudentsWithSubmissions();
        //this.courseController.listCoursesWithResources();
        //this.courseController.listCoursesWithMoreThan5Resources();
        //this.courseController.listCoursesByDateWithStudents(LocalDate.now());
        //this.studentController.listStudentInfo();

        //Problem 16. Get Users by Email Provider
        //this.userController.usersByEmailProvider(bufferedReader.readLine());

        //Problem 17.	Count Users with Bigger Pictures
        //this.userController.usersWithPicturesWidthBiggerThan(Integer.parseInt(bufferedReader.readLine()));

        //Problem 18. Remove Inactive Users
        this.userController.removeInactiveUsers(bufferedReader.readLine());

    }
}