package betting.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "continents")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "continent_id")
    private long id;

    @Column(name = "continent_name")
    private String name;

    @ManyToMany(mappedBy = "continents", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Country> countries;

    public Continent() {
    }

    public Continent(String name, Set<Country> countries) {
        this.name = name;
        this.countries = countries;
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

    public Set<Country> getCountries() {
        return this.countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }
}
