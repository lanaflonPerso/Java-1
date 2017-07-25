package betting.entities;

import java.io.Serializable;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

public class BetGamesId implements Serializable {

    private static final long serialVersionUID = -2834827403836993112L;

    private Game game;
    private Bet bet;

    public BetGamesId() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((game == null) ? 0 : game.hashCode());
        result = prime * result + ((bet == null) ? 0 : bet.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BetGamesId other = (BetGamesId) obj;
        if (game == null) {
            if (other.game != null)
                return false;
        } else if (!game.equals(other.game))
            return false;
        if (bet == null) {
            if (other.bet != null)
                return false;
        } else if (!bet.equals(other.bet))
            return false;
        return true;
    }
}
