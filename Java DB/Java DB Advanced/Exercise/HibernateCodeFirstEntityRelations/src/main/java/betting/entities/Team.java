package betting.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private long id;

    @Column(name = "team_name")
    private String name;

    @Column(length = 3)
    private String logo;

    @Basic
    private String initials;

    @Basic
    private double budget;

    @ManyToOne(optional = false)
    @JoinColumn(name = "teamsPrimary")
    private Color primaryKitColor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "teamsSecondary")
    private Color secondaryKitColor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "town_id")
    private Town town;

    public Team() {
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

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getInitials() {
        return this.initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public double getBudget() {
        return this.budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Color getPrimaryKitColor() {
        return this.primaryKitColor;
    }

    public void setPrimaryKitColor(Color primaryKitColor) {
        this.primaryKitColor = primaryKitColor;
    }

    public Color getSecondaryKitColor() {
        return this.secondaryKitColor;
    }

    public void setSecondaryKitColor(Color secondaryKitColor) {
        this.secondaryKitColor = secondaryKitColor;
    }

    public Town getTown() {
        return this.town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
