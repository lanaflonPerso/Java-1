package hospital.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private long id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Basic
    private String address;

    @Basic
    private String email;

    @Basic
    private LocalDate dateOfBirth;

    @Basic
    private byte[] picture;

    @Column(name = "has_medical_insurance")
    private boolean hasMedicalInsurance;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.PERSIST)
    private Set<Visitation> visitations;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.PERSIST)
    private Set<Diagnose> diagnoses;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.PERSIST)
    private Set<Medicament> medicaments;

    public Patient() {
        this.visitations = new HashSet<>();
        this.diagnoses = new HashSet<>();
        this.medicaments = new HashSet<>();
    }

    public Patient(String firstName, String lastName, String address, String email, LocalDate dateOfBirth, byte[] picture, boolean hasMedicalInsurance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.picture = picture;
        this.hasMedicalInsurance = hasMedicalInsurance;
        this.visitations = new HashSet<>();
        this.diagnoses = new HashSet<>();
        this.medicaments = new HashSet<>();
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

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public byte[] getPicture() {
        return this.picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public boolean isHasMedicalInsurance() {
        return this.hasMedicalInsurance;
    }

    public void setHasMedicalInsurance(boolean hasMedicalInsurance) {
        this.hasMedicalInsurance = hasMedicalInsurance;
    }

    public Set<Visitation> getVisitations() {
        return this.visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }

    public Set<Diagnose> getDiagnoses() {
        return this.diagnoses;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public Set<Medicament> getMedicaments() {
        return this.medicaments;
    }

    public void setMedicaments(Set<Medicament> medicaments) {
        this.medicaments = medicaments;
    }

    public void addVisitation(Visitation visitation) {
        this.visitations.add(visitation);
    }

    public void addDiagnose(Diagnose diagnose) {
        this.diagnoses.add(diagnose);
    }

    public void addMedicament(Medicament medicament) {
        this.medicaments.add(medicament);
    }
}
