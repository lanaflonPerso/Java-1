package student.system.entities;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Hristo Skipernov on 22/07/2017.
 */

@Entity
@Table(name = "homework_submissions")
public class HomeworkSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "homework_submission_id")
    private long id;

    @Column(nullable = false)
    private String content;

    @Column(name = "content_type", nullable = false)
    private String contentType;

    @Column(name = "submission_date", nullable = false)
    private LocalDate submissionDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id")
    private Course course;

    public HomeworkSubmission() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public LocalDate getSubmissionDate() {
        return this.submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "HomeworkSubmission{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", contentType='" + contentType + '\'' +
                ", submissionDate=" + submissionDate +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}