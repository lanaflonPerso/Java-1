package betting.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

@Entity
@Table(name = "bet_games")
@IdClass(BetGamesId.class)
public class BetGames {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private Game game;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private Bet bet;

    @OneToOne(optional = false)
    @JoinColumn(name = "result_prediction_id")
    private ResultPrediction resultPrediction;

    public BetGames() {
    }

    public BetGames(ResultPrediction resultPrediction, Game game, Bet bet) {
        this.resultPrediction = resultPrediction;
        this.game = game;
        this.bet = bet;
    }

    public ResultPrediction getResultPrediction() {
        return this.resultPrediction;
    }

    public void setResultPrediction(ResultPrediction resultPrediction) {
        this.resultPrediction = resultPrediction;
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Bet getBet() {
        return this.bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }
}
