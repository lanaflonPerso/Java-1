package wedding.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "presents")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "present_type")
public abstract class Present {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "present_id")
    private long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "owner_id")
    private Person owner;

    protected Present() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getOwner() {
        return this.owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
