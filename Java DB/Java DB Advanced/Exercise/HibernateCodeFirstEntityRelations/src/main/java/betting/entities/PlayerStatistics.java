package betting.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

@Entity
@Table(name = "player_statistics")
@IdClass(PlayerStatisticsId.class)
public class PlayerStatistics {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private Game game;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private Player player;

    @Column(name = "scored_goals")
    private int scoredGoals;

    @Column(name = "player_assists")
    private int plaerAssists;

    @Column(name = "played_minutes")
    private int playedMinutes;

    public PlayerStatistics() {
    }

    public PlayerStatistics(Game game, Player player, int scoredGoals, int plaerAssists, int playedMinutes) {
        this.game = game;
        this.player = player;
        this.scoredGoals = scoredGoals;
        this.plaerAssists = plaerAssists;
        this.playedMinutes = playedMinutes;
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getScoredGoals() {
        return this.scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public int getPlaerAssists() {
        return this.plaerAssists;
    }

    public void setPlaerAssists(int plaerAssists) {
        this.plaerAssists = plaerAssists;
    }

    public int getPlayedMinutes() {
        return this.playedMinutes;
    }

    public void setPlayedMinutes(int playedMinutes) {
        this.playedMinutes = playedMinutes;
    }
}
