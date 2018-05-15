package betting.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

@Entity
@Table(name = "competitions")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "competition_id")
    private long id;

    @Column(name = "competition_name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "competition_tipe_id")
    private CompetitionType competitionType;

    @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Game> games;

    public Competition() {
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

    public CompetitionType getCompetitionType() {
        return this.competitionType;
    }

    public void setCompetitionType(CompetitionType competitionType) {
        this.competitionType = competitionType;
    }

    public Set<Game> getGames() {
        return this.games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
