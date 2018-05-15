package photography.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 30/07/2017.
 */

@Entity
@Table(name = "workshops")
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workshop_id")
    private long id;

    @Column(name = "workshop_name")
    @NotNull
    private String name;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Basic
    @NotNull
    private String location;

    @Column(name = "price_per_participant")
    @NotNull
    private BigDecimal pricePerParticipant;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id")
    @NotNull
    private Photographer trainer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "workshops_photographers",
    joinColumns = @JoinColumn(name = "workshop_id"),
    inverseJoinColumns = @JoinColumn(name = "photographer_id"),
    foreignKey = @ForeignKey(name = "fk_workshops_photographers_workshops"),
    inverseForeignKey = @ForeignKey(name = "fk_workshops_photographers_photographers"))
    private Set<Photographer> participants;

    public Workshop() {
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

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getPricePerParticipant() {
        return this.pricePerParticipant;
    }

    public void setPricePerParticipant(BigDecimal pricePerParticipant) {
        this.pricePerParticipant = pricePerParticipant;
    }

    public Photographer getTrainer() {
        return this.trainer;
    }

    public void setTrainer(Photographer trainer) {
        this.trainer = trainer;
    }

    public Set<Photographer> getParticipants() {
        return this.participants;
    }

    public void setParticipants(Set<Photographer> participants) {
        this.participants = participants;
    }
}
