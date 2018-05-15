package betting.services;

import betting.entities.ResultPrediction;
import betting.repositories.ResultPredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ResultPredictionServiceImpl implements ResultPredictionService {

    private final ResultPredictionRepository resultpredictionRepository;

    @Autowired
    public ResultPredictionServiceImpl(ResultPredictionRepository resultpredictionRepository) {
        this.resultpredictionRepository = resultpredictionRepository;
    }

    @Override
    public List<ResultPrediction> findAll() {
        return this.resultpredictionRepository.findAll();
    }

    @Override
    public ResultPrediction findById(long id) {
        return this.resultpredictionRepository.findOne(id);
    }

    @Override
    public ResultPrediction create(ResultPrediction resultprediction) {
        return this.resultpredictionRepository.save(resultprediction);
    }

    @Override
    public List<ResultPrediction> multipleCreate(Iterable<ResultPrediction> resultpredictions) {
        return this.resultpredictionRepository.save(resultpredictions);
    }

    @Override
    public void deleteById(long id) {
        this.resultpredictionRepository.delete(id);
    }

}
