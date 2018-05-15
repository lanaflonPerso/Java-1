package student.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import student.system.entities.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT CONCAT_WS(' - ', s.student_name, count(c.id), sum(c.price), avg(c.price))\n" +
            "  FROM students AS s\n" +
            "INNER JOIN students_courses AS sc\n" +
            "ON s.student_id = sc.student_id\n" +
            "INNER JOIN courses AS c\n" +
            "ON sc.course_id = c.id\n" +
            "GROUP BY s.student_id\n" +
            "ORDER BY sum(c.price) DESC, count(c.id) DESC, s.student_name;", nativeQuery = true)
    List<String> findStudentsInfo();

}