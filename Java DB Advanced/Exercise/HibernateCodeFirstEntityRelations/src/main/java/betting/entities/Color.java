package betting.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

@Entity
@Table(name = "colors")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id")
    private long id;

    @Column(name = "color_name")
    private String name;

    @OneToMany(mappedBy = "primaryKitColor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Team> teamsPrimary;

    @OneToMany(mappedBy = "secondaryKitColor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Team> teamsSecondary;

    public Color() {
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

    public Set<Team> getTeamsPrimary() {
        return this.teamsPrimary;
    }

    public void setTeamsPrimary(Set<Team> teamsPrimary) {
        this.teamsPrimary = teamsPrimary;
    }

    public Set<Team> getTeamsSecondary() {
        return this.teamsSecondary;
    }

    public void setTeamsSecondary(Set<Team> teamsSecondary) {
        this.teamsSecondary = teamsSecondary;
    }
}
