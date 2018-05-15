package university.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */
@Entity
@Table(name = "teachers")
@PrimaryKeyJoinColumn(name = "person_id")
public class Teacher extends Person {

    @Basic
    private String email;

    @Column(name = "salary_per_hour")
    private double salaryPerHour;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Course> courses;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String phoneNumber, String email, double salaryPerHour, Set<Course> courses) {
        super(firstName, lastName, phoneNumber);
        this.email = email;
        this.salaryPerHour = salaryPerHour;
        this.courses = courses;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalaryPerHour() {
        return this.salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public Set<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}