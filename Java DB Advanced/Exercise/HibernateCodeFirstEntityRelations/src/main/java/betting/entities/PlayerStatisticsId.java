package betting.entities;

import java.io.Serializable;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

public class PlayerStatisticsId implements Serializable {

    private static final long serialVersionUID = -2834827403836993112L;

    private Game game;
    private Player player;

    public PlayerStatisticsId() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((game == null) ? 0 : game.hashCode());
        result = prime * result + ((player == null) ? 0 : player.hashCode());
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
        PlayerStatisticsId other = (PlayerStatisticsId) obj;
        if (game == null) {
            if (other.game != null)
                return false;
        } else if (!game.equals(other.game))
            return false;
        if (player == null) {
            if (other.player != null)
                return false;
        } else if (!player.equals(other.player))
            return false;
        return true;
    }
}