package betting.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", length = 3)
    private String id;

    @Column(name = "country_name")
    private String name;

    @ManyToMany
    @JoinTable(name = "countries_continents",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "continent_id"),
            foreignKey = @ForeignKey(name = "fk_countries_continents_countries"),
            inverseForeignKey = @ForeignKey(name = "fk_countries_continents_continents"))
    private Set<Continent> continents;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Town> towns;

    public Country() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Continent> getContinents() {
        return this.continents;
    }

    public void setContinents(Set<Continent> continents) {
        this.continents = continents;
    }

    public Set<Town> getTowns() {
        return this.towns;
    }

    public void setTowns(Set<Town> towns) {
        this.towns = towns;
    }
}
