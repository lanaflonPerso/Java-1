package game.services;

import game.entities.Game;
import game.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> findAll() {
        return this.gameRepository.findAll();
    }

    @Override
    public Game findById(long id) {
        return this.gameRepository.findOne(id);
    }

    @Override
    public Game findGameByTitle(String title) {
        return this.gameRepository.findGameByTitle(title);
    }

    @Override
    public Game createOne(Game game) {
        return this.gameRepository.save(game);
    }

    @Override
    public List<Game> createMany(Iterable<Game> games) {
        return this.gameRepository.save(games);
    }

    @Override
    public Game updateOne(Game game) {
        return this.gameRepository.save(game);
    }

    @Override
    public List<Game> updateMany(Iterable<Game> games) {
        return this.gameRepository.save(games);
    }

    @Override
    @Modifying
    public void deleteById(long id) {
        this.gameRepository.delete(id);
    }

    @Override
    @Modifying
    public void deleteByGame(Game game) {
        this.gameRepository.delete(game);
    }

}
