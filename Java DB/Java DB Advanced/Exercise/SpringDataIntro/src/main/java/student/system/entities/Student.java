package student.system.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 22/07/2017.
 */

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long id;

    @Column(name = "student_name", nullable = true)
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @Basic
    private LocalDate birthday;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "students_courses",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id"),
    foreignKey = @ForeignKey(name = "fk_students_courses_students"),
    inverseForeignKey = @ForeignKey(name = "fk_students_courses_courses"))
    private Set<Course> courses;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<HomeworkSubmission> homeworkSubmissions;

    public Student() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Set<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<HomeworkSubmission> getHomeworkSubmissions() {
        return this.homeworkSubmissions;
    }

    public void setHomeworkSubmissions(Set<HomeworkSubmission> homeworkSubmissions) {
        this.homeworkSubmissions = homeworkSubmissions;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", registrationDate=" + registrationDate +
                ", birthday=" + birthday +
                ", courses=" + courses +
                ", HomeworkSubmissions=" + homeworkSubmissions +
                '}';
    }
}
