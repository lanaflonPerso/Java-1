package wedding.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "invitations")
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invitation_id")
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "wedding_id")
    private Wedding wedding;

    @NotNull
    @OneToOne
    @JoinColumn(name = "guest_id")
    private Person guest;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "present_id")
    private Present present;

    @Basic
    private boolean attending;

    @NotNull
    @Basic
    private String family;

    public Invitation() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Wedding getWedding() {
        return this.wedding;
    }

    public void setWedding(Wedding wedding) {
        this.wedding = wedding;
    }

    public Person getGuest() {
        return this.guest;
    }

    public void setGuest(Person guest) {
        this.guest = guest;
    }

    public Present getPresent() {
        return this.present;
    }

    public void setPresent(Present present) {
        this.present = present;
    }

    public boolean isAttending() {
        return this.attending;
    }

    public void setAttending(boolean attending) {
        this.attending = attending;
    }

    public String getFamily() {
        return this.family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
