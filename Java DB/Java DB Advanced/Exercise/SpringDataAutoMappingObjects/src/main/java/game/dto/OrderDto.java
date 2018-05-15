package game.dto;

import java.util.Set;

/**
 * Created by Hristo Skipernov on 30/07/2017.
 */

public class OrderDto {

    private UserDto user;

    private Set<GameDto> games;

    public OrderDto() {
    }

    public UserDto getUser() {
        return this.user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Set<GameDto> getGames() {
        return this.games;
    }

    public void setGames(Set<GameDto> games) {
        this.games = games;
    }
}
