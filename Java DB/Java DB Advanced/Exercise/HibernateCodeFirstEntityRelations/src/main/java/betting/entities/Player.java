package betting.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private long id;

    @Column(name = "player_name")
    private String name;

    @Column(name = "squad_number")
    private String squadNumber;

    @Column(name = "is_injured")
    private boolean isInjured;

    @ManyToOne(optional = false)
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne(optional = false)
    @JoinColumn(name = "position_id")
    private Position position;

    public Player() {
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

    public String getSquadNumber() {
        return this.squadNumber;
    }

    public void setSquadNumber(String squadNumber) {
        this.squadNumber = squadNumber;
    }

    public boolean isInjured() {
        return this.isInjured;
    }

    public void setInjured(boolean injured) {
        isInjured = injured;
    }

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
