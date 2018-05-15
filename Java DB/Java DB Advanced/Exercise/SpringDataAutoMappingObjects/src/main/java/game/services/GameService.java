package game.services;

import game.entities.Game;

import java.util.List;

public interface GameService {

    List<Game> findAll();

    Game findById(long id);

    Game findGameByTitle(String title);

    Game createOne(Game game);

    List<Game> createMany(Iterable<Game> games);

    Game updateOne(Game game);

    List<Game> updateMany(Iterable<Game> games);

    void deleteById(long id);

    void deleteByGame(Game game);
}
