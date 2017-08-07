package photography.entities;

import org.hibernate.validator.constraints.Length;
import photography.annotations.Phone;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 30/07/2017.
 */

@Entity
@Table(name = "photographers")
public class Photographer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photographer_id")
    private long id;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @Length(min = 2, max = 50)
    private String lastName;

    @Phone
    private String phone;

    @ManyToOne(optional = false)
    @JoinColumn(name = "primary_camera_id")
    private Camera primaryCamera;

    @ManyToOne(optional = false)
    @JoinColumn(name = "secondary_camera_id")
    private Camera secondaryCamera;

    @OneToMany(mappedBy = "lensOwner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Lens> lenses;

    @OneToMany(mappedBy = "accessoryOwner")
    private Set<Accessory> accessories;

    @OneToMany(mappedBy = "trainer")
    private Set<Workshop> trainerWorkshops;

    @ManyToMany(mappedBy = "participants")
    private Set<Workshop> workshops;

    public Photographer() {
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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Camera getPrimaryCamera() {
        return this.primaryCamera;
    }

    public void setPrimaryCamera(Camera primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public Camera getSecondaryCamera() {
        return this.secondaryCamera;
    }

    public void setSecondaryCamera(Camera secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    public Set<Lens> getLenses() {
        return this.lenses;
    }

    public void setLenses(Set<Lens> lenses) {
        this.lenses = lenses;
    }

    public Set<Accessory> getAccessories() {
        return this.accessories;
    }

    public void setAccessories(Set<Accessory> accessories) {
        this.accessories = accessories;
    }

    public Set<Workshop> getTrainerWorkshops() {
        return this.trainerWorkshops;
    }

    public void setTrainerWorkshops(Set<Workshop> trainerWorkshops) {
        this.trainerWorkshops = trainerWorkshops;
    }

    public Set<Workshop> getWorkshops() {
        return this.workshops;
    }

    public void setWorkshops(Set<Workshop> workshops) {
        this.workshops = workshops;
    }
}
