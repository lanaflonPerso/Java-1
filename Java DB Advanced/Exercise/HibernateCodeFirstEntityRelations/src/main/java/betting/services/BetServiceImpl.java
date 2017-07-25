package betting.services;

import betting.entities.Bet;
import betting.repositories.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BetServiceImpl implements BetService {

    private final BetRepository betRepository;

    @Autowired
    public BetServiceImpl(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    @Override
    public List<Bet> findAll() {
        return this.betRepository.findAll();
    }

    @Override
    public Bet findById(long id) {
        return this.betRepository.findOne(id);
    }

    @Override
    public Bet create(Bet bet) {
        return this.betRepository.save(bet);
    }

    @Override
    public List<Bet> multipleCreate(Iterable<Bet> bets) {
        return this.betRepository.save(bets);
    }

    @Override
    public void deleteById(long id) {
        this.betRepository.delete(id);
    }

}
