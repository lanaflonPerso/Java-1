package betting.services;

import betting.entities.Game;

import java.util.List;

public interface GameService {

    List<Game> findAll();

    Game findById(long id);

    Game create(Game game);

    List<Game> multipleCreate(Iterable<Game> games);

    void deleteById(long id);
}
