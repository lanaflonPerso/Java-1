package betting.services;

import betting.entities.ResultPrediction;

import java.util.List;

public interface ResultPredictionService {

    List<ResultPrediction> findAll();

    ResultPrediction findById(long id);

    ResultPrediction create(ResultPrediction resultprediction);

    List<ResultPrediction> multipleCreate(Iterable<ResultPrediction> resultpredictions);

    void deleteById(long id);
}
