package betting.services;

import betting.entities.Game;
import betting.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Game create(Game game) {
        return this.gameRepository.save(game);
    }

    @Override
    public List<Game> multipleCreate(Iterable<Game> games) {
        return this.gameRepository.save(games);
    }

    @Override
    public void deleteById(long id) {
        this.gameRepository.delete(id);
    }

}
