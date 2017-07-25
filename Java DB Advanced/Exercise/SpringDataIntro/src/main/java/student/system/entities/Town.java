package student.system.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

@Entity
@Table(name = "towns")
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "town_id")
    private long id;

    @Column(name = "town_name")
    private String name;

    @Basic
    private String country;

    @OneToMany(mappedBy = "bornTown", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<User> bornInTownUsers;


    @OneToMany(mappedBy = "currentlyLivingTown", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<User> currentlyLivingUsers;

    public Town() {
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

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<User> getBornInTownUsers() {
        return this.bornInTownUsers;
    }

    public void setBornInTownUsers(Set<User> bornInTownUsers) {
        this.bornInTownUsers = bornInTownUsers;
    }

    public Set<User> getCurrentlyLivingUsers() {
        return this.currentlyLivingUsers;
    }

    public void setCurrentlyLivingUsers(Set<User> currentlyLivingUsers) {
        this.currentlyLivingUsers = currentlyLivingUsers;
    }
}
