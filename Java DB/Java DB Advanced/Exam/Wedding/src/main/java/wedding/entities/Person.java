package wedding.entities;

import org.hibernate.validator.constraints.Length;
import wedding.annotations.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private long id;

    @Length(min = 1, max = 60)
    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name_initial")
    @Length(max = 1)
    @NotNull
    private String middleNameInitial;

    @Column(name = "last_name")
    @Length(min = 2)
    @NotNull
    private String lastName;

    @Transient
    private String fullName;

    @NotNull
    private String gender;

    @Column(name = "birth_date")
    private Date birthDate;

    @Transient
    private int age;

    @Basic
    private String phone;

    @Email
    private String email;

    public Person() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleNameInitial() {
        return this.middleNameInitial;
    }

    public void setMiddleNameInitial(String middleNameInitial) {
        this.middleNameInitial = middleNameInitial;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        if (this.fullName == null) {
            return this.firstName + " " + this.middleNameInitial + " " + this.lastName;
        }
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        if (!"Male".equals(gender) && !"Female".equals(gender)) {
            this.gender = "Not Specified";
        } else {
            this.gender = gender;
        }
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
