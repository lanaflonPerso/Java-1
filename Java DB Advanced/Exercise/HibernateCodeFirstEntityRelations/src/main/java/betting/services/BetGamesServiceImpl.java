package betting.services;

import betting.entities.BetGames;
import betting.repositories.BetGamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BetGamesServiceImpl implements BetGamesService {

    private final BetGamesRepository betgamesRepository;

    @Autowired
    public BetGamesServiceImpl(BetGamesRepository betgamesRepository) {
        this.betgamesRepository = betgamesRepository;
    }

    @Override
    public List<BetGames> findAll() {
        return this.betgamesRepository.findAll();
    }

    @Override
    public BetGames findById(long id) {
        return this.betgamesRepository.findOne(id);
    }

    @Override
    public BetGames create(BetGames betgames) {
        return this.betgamesRepository.save(betgames);
    }

    @Override
    public List<BetGames> multipleCreate(Iterable<BetGames> betgamess) {
        return this.betgamesRepository.save(betgamess);
    }

    @Override
    public void deleteById(long id) {
        this.betgamesRepository.delete(id);
    }

}
