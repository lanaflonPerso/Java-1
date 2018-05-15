package wedding.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "weddings")
public class Wedding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wedding_id")
    private long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "bride_id")
    private Person bride;

    @NotNull
    @OneToOne
    @JoinColumn(name = "bridegroom_id")
    private Person bridegroom;

    @NotNull
    private Date date;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @ManyToMany
    @JoinTable(name = "weddings_venues",
            joinColumns = @JoinColumn(name = "wedding_id"),
            inverseJoinColumns = @JoinColumn(name = "venue_id"))
    private Set<Venue> venues;

    @OneToMany(mappedBy = "wedding", cascade = CascadeType.PERSIST)
    private Set<Invitation> invitations;

    public Wedding() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getBride() {
        return this.bride;
    }

    public void setBride(Person bride) {
        this.bride = bride;
    }

    public Person getBridegroom() {
        return this.bridegroom;
    }

    public void setBridegroom(Person bridegroom) {
        this.bridegroom = bridegroom;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Agency getAgency() {
        return this.agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Set<Venue> getVenues() {
        return this.venues;
    }

    public void setVenues(Set<Venue> venues) {
        this.venues = venues;
    }

    public Set<Invitation> getInvitations() {
        return this.invitations;
    }

    public void setInvitations(Set<Invitation> invitations) {
        this.invitations = invitations;
    }
}
