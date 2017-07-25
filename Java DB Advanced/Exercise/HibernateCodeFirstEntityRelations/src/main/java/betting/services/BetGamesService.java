package betting.services;

import betting.entities.BetGames;

import java.util.List;

public interface BetGamesService {

    List<BetGames> findAll();

    BetGames findById(long id);

    BetGames create(BetGames betgames);

    List<BetGames> multipleCreate(Iterable<BetGames> betgamess);

    void deleteById(long id);
}
