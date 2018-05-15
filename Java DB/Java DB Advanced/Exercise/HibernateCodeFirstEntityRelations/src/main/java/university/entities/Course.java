package university.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private long id;

    @Column(name = "name_description")
    private String nameDescription;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Basic
    private int credits;

    @ManyToMany
    @JoinTable(name = "courses_students",
    joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"),
    foreignKey = @ForeignKey(name = "fk_courses_students_courses"),
    inverseForeignKey = @ForeignKey(name = "fk_courses_students_students"))
    private Set<Student> students;

    @ManyToOne(optional = false)
    @JoinColumn(name = "teacher_id", foreignKey = @ForeignKey(name = "courses_teachers"))
    private Teacher teacher;

    public Course() {
    }

    public Course(String nameDescription, LocalDate startDate, LocalDate endDate, int credits, Set<Student> students, Teacher teacher) {
        this.nameDescription = nameDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.credits = credits;
        this.students = students;
        this.teacher = teacher;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameDescription() {
        return this.nameDescription;
    }

    public void setNameDescription(String nameDescription) {
        this.nameDescription = nameDescription;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getCredits() {
        return this.credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Set<Student> getStudents() {
        return this.students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
