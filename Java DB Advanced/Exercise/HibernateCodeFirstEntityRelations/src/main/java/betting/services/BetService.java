package betting.services;

import betting.entities.Bet;

import java.util.List;

public interface BetService {

    List<Bet> findAll();

    Bet findById(long id);

    Bet create(Bet bet);

    List<Bet> multipleCreate(Iterable<Bet> bets);

    void deleteById(long id);
}
