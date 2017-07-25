package betting.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private long id;

    @Column(name = "home_teams_goals")
    private int homeTeamsGoals;

    @Column(name = "away_teams_goals")
    private int awayTeamsGoals;

    @Column(name = "date_time")
    private LocalDateTime datetime;

    @Column(name = "home_team_win_bet_rate")
    private double homeTeamWinBetRate;

    @Column(name = "away_team_win_bet_rate")
    private double awayTeamWinBetRate;

    @Column(name = "draw_game_bet_rate")
    private double drawGameBetRate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @ManyToOne(optional = false)
    @JoinColumn(name = "round_id")
    private Round round;

    @OneToOne(optional = false)
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @OneToOne(optional = false)
    @JoinColumn(name = "away_team_id")
    private Team awayTeam;

    public Game() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHomeTeamsGoals() {
        return this.homeTeamsGoals;
    }

    public void setHomeTeamsGoals(int homeTeamsGoals) {
        this.homeTeamsGoals = homeTeamsGoals;
    }

    public int getAwayTeamsGoals() {
        return this.awayTeamsGoals;
    }

    public void setAwayTeamsGoals(int awayTeamsGoals) {
        this.awayTeamsGoals = awayTeamsGoals;
    }

    public LocalDateTime getDatetime() {
        return this.datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public double getHomeTeamWinBetRate() {
        return this.homeTeamWinBetRate;
    }

    public void setHomeTeamWinBetRate(double homeTeamWinBetRate) {
        this.homeTeamWinBetRate = homeTeamWinBetRate;
    }

    public double getAwayTeamWinBetRate() {
        return this.awayTeamWinBetRate;
    }

    public void setAwayTeamWinBetRate(double awayTeamWinBetRate) {
        this.awayTeamWinBetRate = awayTeamWinBetRate;
    }

    public double getDrawGameBetRate() {
        return this.drawGameBetRate;
    }

    public void setDrawGameBetRate(double drawGameBetRate) {
        this.drawGameBetRate = drawGameBetRate;
    }

    public Competition getCompetition() {
        return this.competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Round getRound() {
        return this.round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Team getHomeTeam() {
        return this.homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return this.awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }
}
