package hospital.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */

@Entity
@Table(name = "diagnoses")
public class Diagnose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diagnose_id")
    private long id;

    @Column(name = "diagnose_name")
    private String name;

    @Basic
    private String comments;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id", foreignKey = @ForeignKey(name = "fk_diagnoses_patients"))
    private Patient patient;

    public Diagnose() {
    }

    public Diagnose(String name, String comments, Patient patient) {
        this.name = name;
        this.comments = comments;
        this.patient = patient;
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
