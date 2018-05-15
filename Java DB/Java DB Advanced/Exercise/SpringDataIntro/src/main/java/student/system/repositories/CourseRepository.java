package student.system.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import student.system.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findCoursesByOrderByStartDateAscEndDateDesc();

    @Query(value = "SELECT CONCAT_WS(' - ', c.course_name, count(r.id))\n" +
            "FROM courses AS c\n" +
            "INNER JOIN resources AS r\n" +
            "ON c.id = r.course_id\n" +
            "GROUP BY c.course_name\n" +
            "HAVING count(r.id) > 5\n" +
            "ORDER BY count(r.id) DESC, c.start_date DESC;", nativeQuery = true)
    List<String> findCoursesWithMoreThan5Resources();

    @Query(value = "SELECT CONCAT_WS(', ', c.course_name, c.start_date, c.end_date, DATEDIFF(c.end_date, c.start_date), count(s.student_id))\n" +
            "FROM courses AS c\n" +
            "  INNER JOIN students_courses AS sc\n" +
            "    ON c.id = sc.course_id\n" +
            "  INNER JOIN students AS s\n" +
            "    ON sc.student_id = s.student_id\n" +
            "WHERE :date BETWEEN c.start_date AND c.end_date\n" +
            "GROUP BY c.id;", nativeQuery = true)
    List<String> coursesActiveOnDate(@Param("date") LocalDate date);

}
