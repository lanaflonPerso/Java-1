package game.dto;

import java.util.Set;

/**
 * Created by Hristo Skipernov on 29/07/2017.
 */

public class UserGamesDto {

    private Set<GameDto> games;

    public UserGamesDto() {

    }

    public Set<GameDto> getGames() {
        return this.games;
    }

    public void setGames(Set<GameDto> games) {
        this.games = games;
    }
}
