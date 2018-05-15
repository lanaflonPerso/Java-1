package hospital.entities;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */

@Entity
@Table(name = "visitations")
public class Visitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visitation_id")
    private long id;

    @Basic
    private LocalDate date;

    @Basic
    private String comments;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id", foreignKey = @ForeignKey(name = "fk_visitations_patients"))
    private Patient patient;

    public Visitation() {
    }

    public Visitation(LocalDate date, String comments, Patient patient) {
        this.date = date;
        this.comments = comments;
        this.patient = patient;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
